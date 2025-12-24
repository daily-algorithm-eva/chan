import java.io.*;
import java.util.*;

class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            boolean[][] map = new boolean[n + 1][n + 1]; // i가 j를 이기는가
            int[] indegree = new int[n + 1]; // i의 순위

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    map[arr[i]][arr[j]] = true;
                    indegree[arr[j]] += 1;
                }
            }
            int m = Integer.parseInt(br.readLine());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (map[a][b]) {
                    map[a][b] = false;
                    map[b][a] = true;
                    indegree[a] += 1;
                    indegree[b] -= 1;
                } else {
                    map[a][b] = true;
                    map[b][a] = false;
                    indegree[a] -= 1;
                    indegree[b] += 1;
                }
            }

            // 위상정렬 시작
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) { // 시작 지점 큐에 넣기
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }

            boolean ambiguous = false;
            int count = 0;
            while (!q.isEmpty()) {
                if (q.size() > 1) {
                    ambiguous = true;
                }
                int node = q.poll();
                sb.append(node + " ");
                count += 1;
                for (int i = 1; i <= n; i++) {
                    if(i == node) continue;
                    if (map[node][i]) {
                        indegree[i]--;
                        if (indegree[i] == 0) {
                            q.add(i);
                        }
                    }
                }
            }
            
            if (count != n) {
                sb.append(n + "\n");
                System.out.println("IMPOSSIBLE");
            } 
            else if(ambiguous) {
                System.out.println("?");
            }
            else {
                System.out.println(sb);
            }

        }
    }
}
