import java.io.*;
import java.util.*;

class Main {
    static int c,n;
    static int[][] arr; 
    static int[] dp; // 고객의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][3];
        
        int len = 0;
        for(int i = 0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());
            arr[i][0] = cost;
            arr[i][1] = customer;
            len = Math.max(len, arr[i][1]);
        }
        dp = new int[c+len+1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;
        for(int i = 0;i<n;i++) {
            for(int j = arr[i][1]; j<=c+len;j++) {
                dp[j] = Math.min(dp[j], dp[j-arr[i][1]] + arr[i][0]);
            }
        }
        
        int res = 100001;
        for(int i = c;i<=c+len;i++) {
            res = Math.min(res, dp[i]);
        }
        System.out.println(res);
    }
}