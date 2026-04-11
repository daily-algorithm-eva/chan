import java.io.*;
import java.util.*;

class Main {
    static int n;
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
    static PriorityQueue<Node> nodes = new PriorityQueue<>(Comparator.comparing(a -> a.w));
    static int[] parents;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        parents = new int[n+1];
        for(int i = 0;i<=n;i++) {
            parents[i] = i;
        }
        
        int totalLen = 0;
        for(int i = 1;i<=n;i++) {
            char[] tmp = br.readLine().toCharArray();
            for(int j = 1;j<=n;j++) {
                if (tmp[j-1] == '0') {
                    continue;
                }
                if (tmp[j-1] >= 'A' && tmp[j-1] <= 'Z') {
                    int w = (int)(tmp[j-1] - 'A') + 27;
                    nodes.add(new Node(i, j, w));
                    totalLen += w;
                }
                else {
                    int w = (int)(tmp[j-1] - 'a' + 1);
                    nodes.add(new Node(i, j, w));
                    totalLen += w;
                }
            }
        }

        int res = 0;
        while(!nodes.isEmpty()) {
            Node node = nodes.poll();
            if(find(node.start) == find(node.end)) {
                continue;
            }
            union(node.start, node.end);
            res += node.w;
        }

        int tmp = find(1);
        boolean isConnected = true;
        for(int i = 2;i<=n;i++) {
            if (find(i) != tmp) {
                isConnected = false;
                break;
            }
        }

        if(isConnected) {
            System.out.println(totalLen - res);
        }
        else {
            System.out.println(-1);
        }
    }

    public static int find(int node) {
        if(parents[node] == node) {
            return node;
        }
        return parents[node] = find(parents[node]);
    }

    public static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);
        
        parents[aParent] = bParent;
    }
}

// 1 : 1 2 3
// 2 : 4 5 6
// 3 : 7 8 9