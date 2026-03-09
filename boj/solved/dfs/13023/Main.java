import java.io.*;
import java.util.*;

class Main {
    static int n,m;
    static int[] arr;
    static boolean[] visited;
    static List<Integer>[] nodes;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        visited = new boolean[n];
        nodes = new List[n];
        for(int i = 0;i<n;i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i = 0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(b);
            nodes[b].add(a);
        }

        for(int i = 0;i<n;i++) {
            visited[i] = true;
            dfs(i,1);
            visited[i] =false;
            if(res == 1) {
                break;
            }
        }

        System.out.println(res);
    }

    public static void dfs(int start, int count) {
        if(count == 5) {
            res = 1;
            return;
        }
        for(int node : nodes[start]) {
            if(res == 1) {
                return;
            }
            if(visited[node]) {
                continue;
            }
            visited[node] = true;
            dfs(node, count + 1);
            visited[node] = false;
        }
    }
}