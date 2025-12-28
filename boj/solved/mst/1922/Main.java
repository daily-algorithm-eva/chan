import java.io.*;
import java.util.*;

class Main {
    static class Node{
        int start;
        int end;
        int w;
        public Node(int start, int end, int w) {
            this.start = start;
            this.end = end;
            this.w = w;
        }
    }
    static int n,m;
    static List<Node> networks;
    static int[] parents;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        networks = new ArrayList<>();
        parents = new int[n+1];
        for(int i = 1;i<=n;i++) {
            parents[i] = i;
        }

        for(int i = 0;i<m;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            networks.add(new Node(a, b, c));
        }
        networks.sort(Comparator.comparing(a -> a.w));

        int count = 0;
        for(Node node : networks) { 
            int parentA = find(node.start);
            int parentB = find(node.end);
            if(parentA == parentB) continue;
            parents[parentB] = parentA;
            count += node.w;
        }
        System.out.println(count);
    }

    public static int find(int node) {
        if(parents[node] == node) return node;
        return parents[node] = find(parents[node]);
    }
}
// 2 3 2
// 4 5 3
// 1 3 4
// 1 2 5
// 3 4 6
// 2 4 7
// 4 6 8
// 5 6 8
// 3 5 11