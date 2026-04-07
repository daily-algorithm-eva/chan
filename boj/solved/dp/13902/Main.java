import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] woks;
    static int[] dp; // i개의 요리하기 위해 필요한 요리 횟수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        woks = new int[m];
        HashSet<Integer> hs = new HashSet<>(); // 한번에 만들수 있는 그릇
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<m;i++) {
            woks[i] = Integer.parseInt(st.nextToken());
            hs.add(woks[i]);
        }
        for(int i = 0; i < m; i++) {
            for(int j = i + 1;j<m;j++) {
                int tmp = woks[i] + woks[j];
                if (tmp <= n) {
                    hs.add(tmp);
                }
            }
        }
        
        dp = new int[n+1];
        Arrays.fill(dp, n+1);
        dp[0] = 0;
        for(int i = 1;i<=n;i++) {
            for(int tmp : hs) {
                if (i - tmp < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i-tmp] + 1);
            }
        }

        if (dp[n] == n+1) {
            System.out.println(-1);
        }
        else {
            System.out.println(dp[n]);
        }
    }
}