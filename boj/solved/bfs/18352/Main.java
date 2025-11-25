import java.io.*;
import java.util.*;

class Main {
    static int n, m, k, x;
    static HashMap<Integer, List<Integer>> hm = new HashMap<>();
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            hm.put(i, new ArrayList<>());
        }
        res = new int[n + 1];
        Arrays.fill(res, 300002);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            hm.get(start).add(end);
        }
        bfs(x);

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (res[i] == k) {
                count += 1;
                sb.append(i + "\n");
            }
        }
        if (count == 0) {
            System.out.println(-1);
        } else {
            System.out.print(sb);
        }
    }

    /* 
    방문 처리하면서 최단 거리를 갱신하며 res 배열에 수집
    */
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        res[start] = 0;
        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int tmp = q.poll();

            for (int a : hm.get(tmp)) {
                if (visited[a])
                    continue;

                if (res[a] > res[tmp] + 1) {
                    visited[a] = true;
                    res[a] = res[tmp] + 1;
                    q.add(a);
                }
            }
        }
    }
}