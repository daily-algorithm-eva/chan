import java.io.*;
import java.util.*;

class Main {
    static class Node {
        int end;
        long w;

        public Node(int end, long w) {
            this.end = end;
            this.w = w;
        }
    }

    static int n, m;
    static List<Node>[] bridges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        bridges = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            bridges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            bridges[a].add(new Node(b, w));
            bridges[b].add(new Node(a, w));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));
    }

    public static long dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(a -> -a.w));
        boolean[] visited = new boolean[n + 1];
        long[] res = new long[n + 1];
        res[start] = 0;
        pq.add(new Node(start, 1000000001));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.end])
                continue;
            visited[node.end] = true;
            if (node.end == end)
                return res[end];

            for (Node next : bridges[node.end]) {
                if (res[next.end] >= Math.min(next.w, node.w))
                    continue;
                res[next.end] = Math.min(next.w, node.w);
                pq.add(new Node(next.end, Math.min(next.w, node.w)));
            }
        }
        return res[end];
    }
}
