import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] values;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        values = new int[n+1];
        dp = new int[n+1][n+1];
        for(int i = 1;i<=n;i++) {
            values[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 1;i<=n;i++) {
            dp[i][0] = dp[i-1][0] + i*values[i];
            dp[0][i] = dp[0][i-1] + i*values[n+1-i]; 
        }

        for(int i = 1;i<=n;i++) {
            for(int j = 1;j<=n;j++) {
                if(i+j > n) break;
                int bigger = Math.max(dp[i-1][j] + (i+j) * values[i], dp[i][j-1] + (i+j) * values[n+1-j]); // 1 1
                dp[i][j] = bigger;
            }
        }

        int res = 0;
        for(int i = 0;i<=n;i++) {
            res = Math.max(res, dp[i][n-i]);
        }
        System.out.println(res);
    }
}
// 13152
// 0 2 12 15 27 32 
// 1 4 15 19 44 0 
// 7 13 27 34 0 0 
// 10 17 32 0 0 0 
// 30 42 0 0 0 0 
// 40 0 0 0 0 0 