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
    static int n;
    static int[] parents;
    static List<Node> nodes;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nodes = new ArrayList<>();
        parents = new int[n+1];

        for(int i = 1;i<=n;i++) {
            nodes.add(new Node(i, 0, Integer.parseInt(br.readLine())));
        }
        for(int i = 1;i<=n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1;j<=n;j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if(i<=j) continue;
                nodes.add(new Node(i, j, tmp));
            }
        }
        for(int i = 1;i<=n;i++) {
            parents[i] = i;
        }

        nodes.sort(Comparator.comparing(a -> a.w));
        mst();

        System.out.println(res);
    }

    public static void mst() {
        for(Node node : nodes) {
            int parentX = find(node.start);
            int parentY = find(node.end);
            if(node.start == node.end) {
                parents[node.start] = 0;
            } 
            if(parentX == parentY) continue;
            union(parentX, parentY);
            res += node.w;
        }
    }

    public static void union(int i, int j) {
        int parentI = find(i);
        int parentJ = find(j);
        parents[parentI] = parentJ;
    }

    public static int find(int num) {
        if(parents[num] == num) {
            return num;
        }
        return find(parents[num]);
    }
}