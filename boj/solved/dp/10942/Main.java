
import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int m;
    static int[] arr;
    static int[][] dp; // 0은 no 1은 yes -1은 미탐색
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n+1];
        dp = new int[n+1][n+1];
        for(int i = 1;i<=n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(dp[i], -1);
        }
        
        m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            isPalin(start, end);
            sb.append(dp[start][end] + "\n");
        }
        System.out.print(sb);
    }

    public static int isPalin(int start, int end) {
        if(start >= end) {
            return dp[start][end] = 1;
        }
        if(dp[start][end] != -1) { // 이미 탐색하였다면
            return dp[start][end];
        }
        
        if(arr[start] == arr[end]) {
            return dp[start][end] = isPalin(start+1, end-1);
        }
        return dp[start][end] = 0;
    }
}
