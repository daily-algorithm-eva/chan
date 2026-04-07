import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }

        // ㅜ 모양의 경우
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if (i + 1 < n && j+2 < m) {
                    int sum = map[i][j] + map[i][j+1] + map[i+1][j+1] + map[i][j+2];
                    res = Math.max(res, sum);
                }
                if (i + 1 < n && j+2 < m) {
                    int sum = map[i+1][j] + map[i+1][j+1] + map[i+1][j+2] + map[i][j+1];
                    res = Math.max(res, sum);
                }
                if (i + 2 < n && j+1 < m) {
                    int sum = map[i+1][j] + map[i+1][j+1] + map[i][j+1] + map[i+2][j+1];
                    res = Math.max(res, sum);
                }
                if (i + 2 < n && j+1 < m) {
                    int sum = map[i][j] + map[i+1][j] + map[i+2][j] + map[i+1][j+1];
                    res = Math.max(res, sum);
                }
            }
        }

        System.out.println(res);
    }

    public static void dfs(int x, int y, int num, int sum) {
        if(num == 4) {
            res = Math.max(res, sum);
            return;
        }

        if (x + 1 < n && !visited[x+1][y]) {
            visited[x+1][y] = true;
            dfs(x + 1, y, num+1, sum + map[x+1][y]);
            visited[x+1][y] = false;
        }
        if (y + 1 < m && !visited[x][y+1]) {
            visited[x][y+1] = true;
            dfs(x, y + 1, num+1, sum + map[x][y + 1]);
            visited[x][y+1] = false;
        }
        if (x - 1 >= 0 && !visited[x-1][y]) {
            visited[x-1][y] = true;
            dfs(x - 1, y, num+1, sum + map[x-1][y]);
            visited[x-1][y] = false;
        }
        if (y - 1 >= 0 && !visited[x][y-1]) {
            visited[x][y-1] = true;
            dfs(x, y - 1, num+1, sum + map[x][y - 1]);
            visited[x][y-1] = false;
        }
    }
}