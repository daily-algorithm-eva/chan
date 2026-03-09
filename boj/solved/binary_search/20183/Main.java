import java.io.*;
import java.util.*;

class Main {
    static int n,m;
    static int a, b;
    static long c;
    static class Node{
        int end;
        long w;
        public Node(int end, long w) {
            this.end = end;
            this.w = w;
        }
    }
    static List<Node>[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Long.parseLong(st.nextToken());
        nodes = new List[n+1];
        for(int i = 0;i<=n;i++) {
            nodes[i] = new ArrayList<>();
        }
        int maxCost = 0;
        for(int i = 0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            nodes[start].add(new Node(end, w));
            nodes[end].add(new Node(start, w));
            maxCost = Math.max(maxCost, w);
        }

        int l = 0;
        int r = maxCost;
        int res = -1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if(dijkstra(mid)) {
                res = mid;
                r = mid-1;
            }else {
                l = mid+1;
            }
        }
        
        System.out.println(res);

    }

    public static boolean dijkstra(int maxCost) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(a -> a.w)); 
        long[] costs = new long[n+1];
        Arrays.fill(costs, c+1);
        pq.add(new Node(a, 0));
        costs[a] = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(costs[node.end] != node.w|| c < node.w) {
                continue;
            }
            if(node.end == b) {
                return true;
            }
            for(Node next : nodes[node.end]) {
                if(next.w > maxCost) {
                    continue;
                }
                if(costs[next.end] <= node.w + next.w || c < node.w + next.w) {
                    continue;
                }
                
                pq.add(new Node(next.end, next.w + node.w));
                costs[next.end] = next.w + node.w;
            }
        }

        return false;
    }
}