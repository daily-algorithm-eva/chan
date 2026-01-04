import java.io.*;
import java.util.*;

class Main {
    static int n, k;
    static int[] arr;
    static boolean[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j])
                    continue;
                if ((i - j) * (1 + (int) Math.abs(arr[j] - arr[i])) <= k) {
                    dp[i] = true;
                    break;
                }

            }
        }
        if (dp[n - 1]) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
