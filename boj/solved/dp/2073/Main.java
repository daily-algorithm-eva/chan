import java.io.*;
import java.util.*;

class Main {
    static int D, P;
    static int[][] pipes;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        pipes = new int[P][2];
        dp = new int[D+1]; // idx 거리르 구하는 최대 수도관 용량

        for(int i = 0;i<P;i++) {
            st = new StringTokenizer(br.readLine());
            pipes[i][0] = Integer.parseInt(st.nextToken());
            pipes[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pipes, Comparator.comparing(a -> a[0]));
        dp[0] = 100001;
        for(int[] pipe : pipes) {
            int d = pipe[0];
            int p = pipe[1];

            for(int i = D;i>= d;i--){ // 더해서 i가 될때
                dp[i] = Math.max(dp[i], Math.min(p, dp[i-d]));
            }
        }
        System.out.println(dp[D]);
    }
}