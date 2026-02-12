import java.io.*;
import java.util.*;

class Main {
    static int n;
    static boolean[][] dp; // i -> j로 갈수 있을떄

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new boolean[52][52];

        for (int i = 0; i < n; i++) {
            char[] tmp = br.readLine().toCharArray();
            char start = tmp[0];
            char end = tmp[tmp.length - 1];
            if (start <= 'Z' && end <= 'Z') { // 둘다 대문자
                dp[start - 'A'][end - 'A'] = true;
            } else if (start <= 'Z') { // end만 소문자
                dp[start - 'A'][end - 'a' + 26] = true;
            } else if (end <= 'Z') { // start만 소문자
                dp[start - 'a' + 26][end - 'A'] = true;
            } else { // 둘다 소문자
                dp[start - 'a' + 26][end - 'a' + 26] = true;
            }
        }

        for (int k = 0; k < 52; k++) {
            for (int i = 0; i < 52; i++) {
                for (int j = 0; j < 52; j++) {
                    if (dp[i][k] && dp[k][j]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 52; j++) {
                if (i == j) {
                    continue;
                }
                if (dp[i][j]) {
                    if (i < 26 && j < 26) {// 둘다 대문자
                        sb.append((char) (i + 'A') + " => " + (char) (j + 'A') + "\n");
                    } else if (i < 26) { // i만 대문자
                        sb.append((char) (i + 'A') + " => " + (char) (j + 'a' - 26) + "\n");
                    } else if (j < 26) { // j만 대문자
                        sb.append((char) (i + 'a' - 26) + " => " + (char) (j + 'A') + "\n");
                    } else {
                        sb.append((char) (i + 'a' - 26) + " => " + (char) (j + 'a' - 26) + "\n");
                    }
                    count +=1;
                }
            }
        }
        System.out.println(count);
        System.out.print(sb);
    }
}