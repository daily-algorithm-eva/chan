import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] parents;
    static int[][] roads;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n+1];
        for(int i = 1;i<=n;i++) {
            parents[i] = i;
        }
        roads = new int[m][3];
        for(int i = 0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            roads[i][0] = Integer.parseInt(st.nextToken());
            roads[i][1] = Integer.parseInt(st.nextToken());
            roads[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(roads, Comparator.comparing(a -> a[2]));
        
        int res = 0;
        int last = 0;
        for(int[] tmp : roads) {
            if(find(tmp[0]) == find(tmp[1])) {
                continue;
            }
            union(tmp[0], tmp[1]);
            res += tmp[2];
            last = tmp[2];
        }

        System.out.println(res - last);
    }

    public static int find(int node) {
        if(parents[node] == node) {
            return node;
        }
        return parents[node] = find(parents[node]);
    }

    public static void union(int a, int b) {
        parents[find(a)] = find(b);
    }
}