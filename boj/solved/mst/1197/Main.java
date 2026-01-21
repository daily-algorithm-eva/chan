import java.io.*;
import java.util.*;

class Main {
    static int v,e;
    static int[][] arr;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        arr = new int[e][3];
        parents = new int[v+1];
        for(int i = 1;i<=v;i++) {
            parents[i] = i;
        }
        for(int i = 0;i<e;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparing(a -> a[2]));
        
        int res = 0;
        for(int[] tmp : arr) {
            if(find(tmp[0]) == find(tmp[1])) {
                continue;
            }
            union(tmp[0], tmp[1]);
            res += tmp[2];
        }

        System.out.println(res);
    }

    public static void union(int a, int b) {
        parents[find(a)] = find(b);
    }

    public static int find(int node) {
        if(parents[node] == node) {
            return node;
        }
        return parents[node] = find(parents[node]);
    }
}
