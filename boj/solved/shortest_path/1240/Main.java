import java.io.*;
import java.util.*;

class Main {
    static int n,m;
    static class Node{
        int end;
        int w;
        public Node(int end, int w) {
            this.end = end;
            this.w = w;
        }
    }
    static int INF = 10000001;
    static List<Node>[] nodes;
    static int[][] res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nodes = new List[n+1];
        res = new int[n+1][n+1];
        for(int i = 0;i<=n;i++) {
            Arrays.fill(res[i], INF);
        }
        for(int i = 0;i<=n;i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0;i<n-1;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodes[start].add(new Node(end, w));
            nodes[end].add(new Node(start, w));
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dijkstra(start, end) + "\n");
        }

        System.out.print(sb);
    }

    public static int dijkstra(int start, int end) {
        if(res[start][end] != INF) {
            return res[start][end];
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(a -> a.w));
        res[start][start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if(node.w > res[start][node.end]) {
                continue;
            }

            for(Node next : nodes[node.end]) {
                if(res[start][next.end] < node.w + next.w) {
                    continue;
                }
                res[start][next.end] = node.w + next.w;
                pq.add(new Node(next.end, node.w + next.w));
            }
        }
        return res[start][end]; 
    }
}
