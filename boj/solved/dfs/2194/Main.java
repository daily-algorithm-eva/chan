import java.io.*;
import java.util.*;

class Main {
    static int n, m, a, b, k;
    static int startX, startY;
    static int endX, endY;
    static int[][] map; // 1 시작 2 끝 -1 장애물
    static int res;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n - a + 2][m - b + 2];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int hurdleX = Integer.parseInt(st.nextToken());
            int hurdleY = Integer.parseInt(st.nextToken());
            for (int j = hurdleX - a + 1; j <= hurdleX; j++) {
                for (int k = hurdleY - b + 1; k <= hurdleY; k++) {
                    if (j < 1 || j >= n - a + 2 || k < 1 || k >= m - b + 2)
                        continue;
                    map[j][k] = -1;
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        endX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());

        if (bfs()) {
            System.out.println(res);
        } else {
            System.out.println(-1);
        }

    }

    public static boolean bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { startX, startY, 0 });
        map[startX][startY] = -1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            if (x == endX && y == endY) {
                res = cur[2];
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 1 || nx > n - a + 1 || ny < 1 || ny > m - b + 1)
                    continue;
                if (map[nx][ny] == -1 || map[nx][ny] == -1)
                    continue;
                map[nx][ny] = -1;
                q.add(new int[] { nx, ny, cur[2] + 1 });
            }
        }
        return false;
    }
}