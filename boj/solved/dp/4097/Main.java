import java.io.*;
import java.util.*;

class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        StringBuilder sb = new StringBuilder();

        while((n = Integer.parseInt(br.readLine())) != 0) {
            int[] dp = new int[n+1];
            for(int i = 1;i<=n;i++) {
                int tmp = Integer.parseInt(br.readLine());
                dp[i] = Math.max(tmp, dp[i-1] + tmp);
            }
            long sum = -2500000000L;
            for(int i = 1;i<=n;i++) {
                sum = Math.max(sum, dp[i]);
            }
            sb.append(sum + "\n");
        }
        System.out.print(sb);
    }
}

