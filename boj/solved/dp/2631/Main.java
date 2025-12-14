import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n]; // i번째까지의 최장 증가 수열 길이

        for(int i = 0;i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        dp[0] = 1;
        for(int i = 1;i<n;i++) {
            for(int j = 0;j<i;j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] +1);
                }
            }
            if(dp[i] == 0) {
                dp[i] = 1;
            }
        }

        int lcs = 0;
        for(int i = 0;i<n;i++) {
            lcs = Math.max(lcs, dp[i]);
        }


        System.out.println(n - lcs);
    }
}