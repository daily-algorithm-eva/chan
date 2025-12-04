import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] arr;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new long[n][21]; // i번째의 j수의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0][arr[0]] = 1;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j < 21; j++) {
                int plus = j + arr[i];
                int minus = j - arr[i];

                if (plus <= 20 && dp[i - 1][j] != 0) {
                    dp[i][plus] += dp[i - 1][j];
                }

                if (minus >= 0 && dp[i - 1][j] != 0) {
                    dp[i][minus] += dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[n - 2][arr[n - 1]]);
    }
}