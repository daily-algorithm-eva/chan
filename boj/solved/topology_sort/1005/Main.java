import java.io.*;
import java.util.*;

class Main {
    static int t;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] buildings = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1;i<=n;i++) {
                buildings[i] = Integer.parseInt(st.nextToken());
            }
            List<Integer>[] edges = new List[n+1];
            int[] degrees = new int[n+1];
            for(int i = 0;i<=n;i++) {
                edges[i] = new ArrayList<>();
            }
            for(int i = 0;i<m;i++) {
                st = new StringTokenizer(br.readLine());
                int nodeA = Integer.parseInt(st.nextToken());
                int nodeB = Integer.parseInt(st.nextToken());
                edges[nodeA].add(nodeB);
                degrees[nodeB] +=1;
            }
            Queue<Integer> q = new LinkedList<>();
            int[] dp = new int[n+1];
            for(int i = 1;i<=n;i++) {
                if(degrees[i] == 0) {
                    q.add(i);
                    dp[i] = buildings[i];
                }
            }
            
            while(!q.isEmpty()) {
                int node = q.poll();
                
                for(int tmp : edges[node]) {
                    degrees[tmp] -=1;
                    dp[tmp] = Math.max(dp[tmp], dp[node] + buildings[tmp]);
                    if(degrees[tmp] == 0) {
                        q.add(tmp);
                    }
                }
            }
            int pointNode = Integer.parseInt(br.readLine());
            

            sb.append(dp[pointNode] + "\n");
        }

        System.out.print(sb);
    }
}
// 루트 노드까지의 dfs가 가장 큰 값을 구함 -> 시간 초과
// 
