import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] arr;
    static int[][] dp; // i부터 j까지의 행렬곱중 최솟값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];
        dp = new int[n][n];
        for(int i = 0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            arr[i][0] = row;
            arr[i][1] = col;
        }
        for(int i = 0;i<n;i++) {
            Arrays.fill(dp[i], 1000000000);
            dp[i][i] = 0;
        }
        for(int len = 1;len<=n;len++) { // 길이
            for(int i = 0; i < n - len; i++) { // j 부터 j + len 까지
                int j = i + len;
                for(int k = i; k< j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + (arr[i][0] * arr[k][1] * arr[j][1]);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
            
        }


        System.out.println(dp[0][n-1]);
    }
}

// a(bc) (ab)c