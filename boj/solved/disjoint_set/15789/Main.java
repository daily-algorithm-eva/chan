import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] parents;
    static int c;
    static int h;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        count = Integer.parseInt(st.nextToken());

        while (count-- > 0) {
            c = find(c);
            h = find(h);
            int big = findBig();
            if (big == 0) {
                break;
            }
            union(c, big);
        }

        c = find(c);
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (find(i) == c) {
                answer += 1;
            }
        }
        System.out.println(answer);
    }

    public static int findBig() {
        int[] sizes = new int[n + 1];
        int max = 0;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = find(i);
            if (tmp == c || tmp == h)
                continue;
            sizes[tmp] += 1;
            if (max < sizes[tmp]) {
                max = sizes[tmp];
                res = tmp;
            }
        }
        return res;
    }

    public static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        parents[parentA] = parentB;
    }

    public static int find(int num) {
        if (parents[num] == num) {
            return num;
        }

        return parents[num] = find(parents[num]);
    }
}
