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

    static List<Node>[] nodes;
    static int n,m;
    static int[][] res; // 최단 거리
    static int[][] firstContainers; // 첫 방문 컨테이너

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        res = new int[n+1][n+1];
        nodes = new List[n+1];
        firstContainers = new int[n+1][n+1];

        for(int i =0;i<=n;i++) {
            nodes[i] = new ArrayList<>();
        }
        for(int i =0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodes[start].add(new Node(end, w));
            nodes[end].add(new Node(start, w));
        }

        for(int i =1;i<=n;i++) {
            Arrays.fill(res[i], 10000000);
        }

        for(int i =1;i<=n;i++) {
            dijkstra(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i =1;i<=n;i++) {
            for(int j =1;j<=n;j++) {
                if(i == j) {
                    sb.append("- ");
                }
                else{
                    sb.append(firstContainers[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(a -> a.w));
        
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(node.w > res[start][node.end]) continue;

            for(Node next : nodes[node.end]) {
                if(res[start][next.end] < next.w + node.w) continue;
                res[start][next.end] = next.w + node.w;

                if(node.end == start) {
                    firstContainers[start][next.end] = next.end;
                }
                else{
                    firstContainers[start][next.end] = firstContainers[start][node.end];
                }
                pq.add(new Node(next.end, next.w + node.w));
            }
        }
    }
}