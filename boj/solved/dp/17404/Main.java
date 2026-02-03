import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] arr;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][3];
        dp = new int[n][3];
        for(int i = 0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0;j<3;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int res = 1000001;
        for(int i = 0;i<3;i++) {
            res = Math.min(res, func(i));
        }

        System.out.println(res);
    }

    public static int func(int startColor) {
        for(int i = 0;i<n;i++) {
            Arrays.fill(dp[i], 1000001);
        }
        dp[0][startColor] = arr[0][startColor];
        for(int i = 1;i<n;i++) {
            dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i-1][2], dp[i-1][0]);
            dp[i][2] = arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        int res = 1000001;
        for(int i = 0;i<3;i++) {
            if(i != startColor) {
                res = Math.min(res, dp[n-1][i]);
            }
        }
        return res;
    }
}