import java.io.*;
import java.util.*;

class Main {
    static class Node{
        int end;
        int w;
        public Node(int end, int w) {
            this.end =end;
            this.w = w;
        }
    }
    static int v,e,p;
    static List<Node>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        nodes = new List[v+1];

        for(int i = 0;i<=v;i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0;i<e;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes[a].add(new Node(b, c));
            nodes[b].add(new Node(a, c));
        }

        int min = dijkstra(1, v);
        if(min == dijkstra(1, p) + dijkstra(p, v)) {
            System.out.println("SAVE HIM");
        }
        else{
            System.out.println("GOOD BYE");
        }
    }

    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(a -> a.w));
        int[] res = new int[v+1];
        boolean[] saves = new boolean[v+1];
        Arrays.fill(res, 50000000);
        res[start] = 0;
        saves[p] = true;
        pq.add(new Node(start, 0));
        

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            for(Node next : nodes[node.end]) {
                if(res[next.end] >= res[node.end] + next.w) {
                    res[next.end] = res[node.end] + next.w;
                    pq.add(new Node(next.end, res[next.end]));
                }
            }
        }
        
        return res[end];
    }
}