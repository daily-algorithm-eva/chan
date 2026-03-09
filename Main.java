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
    static int n, m;
    static List<Node>[] arr;
    static int hideNum, hideDist = 0, hideCount;
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new List[n+1];
        for(int i = 0;i<=n;i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b, 1));
            arr[b].add(new Node(a, 1));
        }

        dijkstra(1);

        System.out.println(hideNum + " " + hideDist + " " + hideCount);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(a -> a.w));
        boolean[] visited = new boolean[n+1];
        int[] res = new int[n+1];
        Arrays.fill(res, 1000000000);
        res[start] = 0;
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            if(visited[node.end]) {
                continue;
            }
            visited[node.end] = true;

            for(Node next : arr[node.end]) {
                if(visited[next.end]) {
                    continue;
                }
                if(node.w + 1 > res[next.end]) {
                    continue;
                }
                pq.add(new Node(next.end, node.w+1));
                res[next.end] = node.w + 1;
            }
        }

        for(int i = 1;i<=n;i++) {
            if(hideDist < res[i]) {
                hideCount = 1;
                hideDist = res[i];
                hideNum = i;
            }
            else if(hideDist == res[i]) {
                hideCount += 1;
            }
        }
    }
}