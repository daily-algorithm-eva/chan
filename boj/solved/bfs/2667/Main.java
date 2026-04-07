import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0;i<n;i++) {
            String[] tmp = br.readLine().split("");
            for(int j = 0;j<n;j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        List<Integer> res = new LinkedList<>();
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    res.add(bfs(i, j));
                }
            }
        }

        res.sort(Comparator.naturalOrder());
        
        StringBuilder sb = new StringBuilder();
        sb.append(res.size() + "\n");
        for(int i = 0;i<res.size();i++) {
            sb.append(res.get(i) + "\n");
        }

        System.out.print(sb);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x, y});
        int count = 0;

        while(!q.isEmpty()) {
            int[] loc = q.poll();
            int locX = loc[0];
            int locY = loc[1];
            if (map[locX][locY] == 0) {
                continue;
            }
            if (visited[locX][locY]) {
                continue;
            }
            visited[locX][locY] = true;
            count +=1;

            int[][] nextLoc = new int[][]{{locX + 1, locY}, {locX - 1, locY}, {locX, locY + 1}, {locX, locY - 1}};

            for(int[] next : nextLoc) {
                int nextX = next[0];
                int nextY = next[1];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                    continue;
                }
                q.add(new int[]{nextX, nextY});
            }
        }
        return count;
    }
}
