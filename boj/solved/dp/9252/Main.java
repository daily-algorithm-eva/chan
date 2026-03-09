import java.io.*;
import java.util.*;

class Main {
    static char[] arrA;
    static char[] arrB;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arrA = br.readLine().toCharArray();
        arrB = br.readLine().toCharArray();
        int sizeA = arrA.length;
        int sizeB = arrB.length;
        dp = new int[sizeA + 1][sizeB + 1];

        for (int i = 1; i <= sizeA; i++) {
            for (int j = 1; j <= sizeB; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if (arrA[i - 1] == arrB[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        if (dp[sizeA][sizeB] == 0) {
            System.out.println(0);
            return;
        }
        System.out.println(dp[sizeA][sizeB]);

        int x = sizeA;
        int y = sizeB;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (dp[x][y] == 0)
                break;
            if (dp[x - 1][y] == dp[x][y]) {
                x -= 1;
                continue;
            }
            if (dp[x][y - 1] == dp[x][y]) {
                y -= 1;
                continue;
            }
            sb.append(arrA[x-1]);
            x -= 1;
            y -= 1;
        }

        System.out.println(sb.reverse());
    }
}
// 0 0 0 0 0 0 0
// 0 0 1 1 1 1 1
// 0 1 1 1 2 2 2
// 0 1 2 2 2 3 3
// 0 1 2 2 2 3 3
// 0 1 2 2 2 3 4
// 0 1 2 3 3 3 4