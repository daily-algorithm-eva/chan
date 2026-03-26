import java.io.*;
import java.util.*;

class Main {
    static int n, m, k;
    static int[][] nums;
    static boolean[][] visited;
    static int res = -1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        nums = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<m;j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0, 0);

        System.out.println(res);
    }

    public static void dfs(int x, int y, int sum, int count) {
        if (count == k) {
            res = Math.max(res, sum);
            return;
        }
        if (x == n) {
            return;
        }
        // 선택할경우
        if (!visited[x][y] && (x-1 < 0 || !visited[x-1][y]) && (y-1 < 0 || !visited[x][y-1])) {
            visited[x][y] = true;
            dfs(x + (int)(y+1)/m, (y+1)%m, sum + nums[x][y], count + 1);
            visited[x][y] = false;
        }

        // 선택 안할 경우
        dfs(x + (int)(y+1)/m, (y+1)%m, sum, count);

    }
}