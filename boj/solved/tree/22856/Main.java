import java.io.*;
import java.util.*;

class Main {
    static class Node{
        int left;
        int right;
        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    static int n;
    static Node[] nodes;
    static int count = 0;
    static boolean[] visited;
    static int[] parents;
    static int end = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nodes = new Node[n+1];
        visited = new boolean[n+1];
        parents = new int[n+1];
        for(int i = 1;i<=n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int mid = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            nodes[mid] = new Node(left, right);
            if(left != -1) {
                parents[left] = mid;
            }
            if(right != -1) {
                parents[right] = mid;
            }
        }
        int root = 0;
        for(int i = 1;i<=n;i++) {
            if(parents[i] == 0) {
                root = i;
                break;
            }
        }
        inOrder(root);
        func(root);

        System.out.println(count);
    }

    public static void inOrder(int node) {
        if(nodes[node].left != -1) {
            inOrder(nodes[node].left);
        }
        end = node;
        if(nodes[node].right != -1) {
            inOrder(nodes[node].right);
        }
    }

    public static void func(int node) {
        visited[node] = true;
        if(nodes[node].left != -1 && !visited[nodes[node].left]) {
            count +=1;
            func(nodes[node].left);
        }
        else if(nodes[node].right != -1 && !visited[nodes[node].right]) {
            count+=1;
            func(nodes[node].right);
        }
        else if(node == end) {
            return;
        }
        else if(parents[node] != 0) {
            count +=1;
            func(parents[node]);
        }
    }
}