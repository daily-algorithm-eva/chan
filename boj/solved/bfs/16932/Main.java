import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[][] map;
    static int[][] group;
    static int[] groupSize;
    static int groupId = 1;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        group = new int[n][m];
        groupSize = new int[n * m + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 그룹
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && group[i][j] == 0) {
                    groupSize[groupId] = bfs(i, j, groupId);
                    groupId++;
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    answer = Math.max(answer, calc(i, j));
                }
            }
        }

        System.out.println(answer);
    }

    static int calc(int x, int y) {
        Set<Integer> set = new HashSet<>();
        int sum = 1;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

            int id = group[nx][ny];
            if (id > 0 && set.add(id)) {
                sum += groupSize[id];
            }
        }
        return sum;
    }

    static int bfs(int sx, int sy, int id) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx, sy});
        group[sx][sy] = id;

        int count = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (map[nx][ny] == 0 || group[nx][ny] != 0) continue;

                group[nx][ny] = id;
                count++;
                q.add(new int[]{nx, ny});
            }
        }
        return count;
    }
}
