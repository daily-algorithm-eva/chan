import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new long[n][n];

        for(int i = 0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                if(dp[i][j] == 0 || arr[i][j] == 0) {
                    continue;
                }
                if(i + arr[i][j] < n) {
                    dp[i+arr[i][j]][j] += dp[i][j];
                }
                if(j + arr[i][j] < n) {
                    dp[i][j+arr[i][j]] += dp[i][j];
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}