import java.io.*;
import java.util.*;

class Main {
    static class Node{
        int end;
        int w;
        public Node(int end, int w) {
            this.end = end;
            this.w = w;
        }
    }
    static int n,m,k;
    static List<Node>[] nodes;
    static int[][] dp; // 몇번까지 몇개를 거쳐서 도착한 합의 최대값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        nodes = new List[n+1];
        dp = new int[n+1][n+1];
        
        for(int i = 0 ;i<=n;i++) {
            nodes[i] = new ArrayList<>();
            Arrays.fill(dp[i], -1);
        }
        for(int i = 0;i<k;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a >= b) continue;
            nodes[a].add(new Node(b, c));
        }
        dp[1][1] = 0;
        for(int i = 1;i<=n;i++) {
            for(Node node : nodes[i]) {
                int end = node.end;
                int w = node.w;
                for(int j = 1;j<=i;j++) {
                    if(dp[i][j] == -1) continue;
                    dp[end][j+1] = Math.max(dp[end][j+1], dp[i][j] + w);
                }
            }
        }
        int res = 0;
        for(int i = 1;i<=m;i++) {
            res = Math.max(res, dp[n][i]);
        }
        System.out.println(res);
    }
}