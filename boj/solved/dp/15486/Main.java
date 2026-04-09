import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][2];
        dp = new int[n+1];

        for(int i = 0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            arr[i][0] = t;
            arr[i][1] = p;
        }

        for(int i = 0;i<n;i++) {
            int t = arr[i][0];
            int p = arr[i][1];
            if(i != 0) {
                dp[i] = Math.max(dp[i], dp[i-1]);
            }
            if(i+t > n) {
                continue;
            }
            dp[i+t] = Math.max(dp[i+t], dp[i] + p);
        }

        int res = 0;
        for(int i = 0;i<=n;i++) {
            res = Math.max(res, dp[i]);
        }

        System.out.println(res);
    }
}
