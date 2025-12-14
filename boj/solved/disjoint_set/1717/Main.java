import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int calc = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (calc == 0) {
                updateParent(a, b);
            } else if (calc == 1) {
                boolean check = checkParent(a, b);
                if (check) {
                    sb.append("YES" + "\n");
                } else {
                    sb.append("NO" + "\n");
                }
            }
        }
        System.out.print(sb);
    }

    public static int findParents(int x) {
        if(parents[x] == x) {
            return x;
        }
        return parents[x] = findParents(parents[x]);
        
    }

    public static void updateParent(int a, int b) {
        a = findParents(a);
        b = findParents(b);
        parents[a] = b;
    }

    public static boolean checkParent(int a, int b) {
        a = findParents(a);
        b = findParents(b);
        if (a == b) {
            return true;
        }
        return false;
    }
}
