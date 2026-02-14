import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] magic = br.readLine().toCharArray();
        char[] devil = br.readLine().toCharArray();
        char[] angel = br.readLine().toCharArray();

        int[][][] dp = new int[angel.length+1][magic.length+1][2]; // i번째의 j번째의 값을 밟았을때

        dp[0][0][0] = 1;
        dp[0][0][1] = 1;
        for(int i = 1;i<=angel.length;i++) {
            dp[i][0][0] = 1;
            dp[i][0][1] = 1;
            for(int j = 1;j<=magic.length;j++) {
                dp[i][j][0] = dp[i - 1][j][0];
                dp[i][j][1] = dp[i - 1][j][1];

                if(devil[i-1] == magic[j-1]) { // 한칸씩 작게
                    dp[i][j][0] += dp[i-1][j-1][1];
                }
                if(angel[i-1] == magic[j-1]) { // 한칸씩 작게
                    dp[i][j][1] += dp[i-1][j-1][0];
                }
            }
        }

        int res = dp[angel.length][magic.length][0] + dp[angel.length][magic.length][1];
        
        System.out.println(res);
    }
}

// 100 000
// 100 100
// 100 110
// 110 120
// 112 120
// 112 121
