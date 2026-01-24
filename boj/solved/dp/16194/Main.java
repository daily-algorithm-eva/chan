import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1;i<=n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp = new int[1001];
        Arrays.fill(dp, 10000001);
        dp[0] = 0;
        for(int i = 1;i<=n;i++) {
            for(int j = 1;j<= n;j++) {
                if(i-j < 0) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i-j] + arr[j]);
            }
        }

        System.out.println(dp[n]);
    }
}