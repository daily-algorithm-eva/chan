import java.io.*;
import java.util.*;

class Main {
    static int t,k;
    static int[][] coins;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        coins = new int[k][2];

        for(int i =0;i<k;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            coins[i][0] = money;
            coins[i][1] = count;
        }

        dp = new int[10001];
        dp[0] = 1;

        // 한 동전으로 만들 수 있는 돈을 누적해서 합을 구한다.
        for(int[] coin : coins) {
            int money = coin[0];
            int count = coin[1];
            for(int i = t; i>=0;i--) {
                for(int j = 1;j<= count;j++) {
                    if(i - money*j>=0) {
                        dp[i] += dp[i-money*j];
                    }
                }
            }
        }
        System.out.println(dp[t]);
    }
}