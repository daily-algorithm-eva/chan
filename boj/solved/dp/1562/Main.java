import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][][] dp; // i길이인 j로 끝나고 비트마스킹인 계단수의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n+1][10][1024];
        for(int i = 1;i<10;i++) {
            dp[1][i][1 << i] = 1;
        }
        
        for(int i = 2;i<=n;i++) {
            for(int j = 0;j<10;j++) {
                for(int k = 0;k<1024;k++) {
                    if(j-1 >= 0) {
                        dp[i][j][k | (1<<j)] = (dp[i][j][k | (1<<j)] + dp[i - 1][j - 1][k]) % 1_000_000_000;
                    }
                    if(j+1 < 10) {
                        dp[i][j][k | (1<<j)] = (dp[i][j][k | (1<<j)] + dp[i - 1][j + 1][k]) % 1_000_000_000;
                    }
                }
            }
        }
        
        long res = 0;
        for(int i = 0;i<10;i++) {
            res = (res + dp[n][i][1023]) % 1_000_000_000;
        }

        System.out.println(res);
    }
}