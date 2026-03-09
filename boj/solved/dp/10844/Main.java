import java.io.*;
import java.util.*;

class Main {
    static int n;
    static long[][] dp;
    static long MOD = 1_000_000_000L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new long[n+1][10]; // i길의의 계단 중 끝이 j인 계단수의 개수
        Arrays.fill(dp[1], 1);
        dp[1][0] = 0;
        for(int i = 2;i<=n;i++) {
            for(int j = 1;j<9;j++) {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD;
            }
            dp[i][0] = dp[i-1][1];
            dp[i][9] = dp[i-1][8];
        }
        long sum = 0;
        for(int i = 0;i<10;i++) {
            sum += dp[n][i];
            sum %= MOD;
        }
        System.out.println(sum);
    }
}

