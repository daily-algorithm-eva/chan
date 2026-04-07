import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] w;
    static int[][] dp; // i의 도시에 도착했을때 비트마스킹 k의 도시를 방문 했을때의 최솟값
    static int INF = 16_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        w = new int[n][n];
        for(int i = 0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[n][1 << n];
        for(int i = 0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(tsp(0, 1)); // 어느 위치에서 시작하던지 최솟값은 같음
    }

    public static int tsp(int city, int mask) {
        if (mask == (1<<n) -1) { // 모두 방문했을 경우
            if (w[city][0] == 0) {
                return INF;
            } 
            return w[city][0];
        }

        if (dp[city][mask] != -1) { // 이미 계산된 경우
            return dp[city][mask];
        }

        dp[city][mask] = INF;

        for(int i = 0;i<n;i++) {
            if((mask & (1 <<i)) == 0 && w[city][i] != 0) { // 방문하지 않았고 이동할 수 있는 경우
                dp[city][mask] = Math.min(dp[city][mask], tsp(i, mask | (1<<i)) + w[city][i]);
            }
        }

        return dp[city][mask];
    }
}