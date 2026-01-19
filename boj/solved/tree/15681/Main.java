import java.io.*;
import java.util.*;

class Main {
    static int n, r, q;
    static List<Integer>[] nodes;
    static List<int[]> levels = new ArrayList<>();
    static int[] subTreeNodes;
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        nodes = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(b);
            nodes[b].add(a);
        }
        levels = new ArrayList<>();
        subTreeNodes = new int[n + 1];
        visited = new boolean[n + 1];
        parents = new int[n + 1];
        Arrays.fill(subTreeNodes, 1);

        checkLevel(r, 1);

        levels.sort(Comparator.comparing(a -> -a[1]));
        for (int[] tmp : levels) {
            subTreeNodes[parents[tmp[0]]] += subTreeNodes[tmp[0]];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int tmp = Integer.parseInt(br.readLine());
            sb.append(subTreeNodes[tmp] + "\n");
        }

        System.out.print(sb);
    }

    public static void checkLevel(int node, int level) {
        visited[node] = true;
        levels.add(new int[] { node, level });
        for (int tmp : nodes[node]) {
            if (visited[tmp]) {
                continue;
            }
            parents[tmp] = node;
            checkLevel(tmp, level + 1);
        }
    }
}