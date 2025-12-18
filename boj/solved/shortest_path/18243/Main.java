import java.io.*;
import java.util.*;

class Main {
    static int n, k;
    static List<Integer>[] friendships;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        friendships = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            friendships[i] = new ArrayList<>();
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friendships[a].add(b);
            friendships[b].add(a);
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dijkstra(i));
        }

        if (res > 6) {
            System.out.println("Big World!");
        } else {
            System.out.println("Small World!");
        }
    }

    public static int dijkstra(int start) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        int[] res = new int[n + 1];
        Arrays.fill(res, 101);

        pq.add(new int[] { start, 0 });
        res[start] = 0;
        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int node = tmp[0];
            int w = tmp[1];

            for (int next : friendships[node]) {
                if (res[next] > w + 1) {
                    res[next] = w + 1;
                    pq.add(new int[] { next, w+1 });
                }
            }
        }
        
        int count = 0;
        for(int i = 1;i<=n;i++) {
            count = Math.max(count, res[i]);
        }
        return count;
    }
}