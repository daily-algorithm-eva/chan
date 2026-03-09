import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static List<Integer>[] arr;
    static int hideNum, hideDist = 0, hideCount;
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new List[n+1];
        for(int i = 0;i<=n;i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        dijkstra(1);

        System.out.println(hideNum + " " + hideDist + " " + hideCount);
    }

    public static void dijkstra(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int[] res = new int[n+1];
        Arrays.fill(res, 1000000000);
        res[start] = 0;
        q.add(start);
        while(!q.isEmpty()) {
            int node = q.poll();
            if(visited[node]) {
                continue;
            }
            visited[node] = true;

            for(int next : arr[node]) {
                if(visited[next]) {
                    continue;
                }
                if(res[node] + 1 > res[next]) {
                    continue;
                }
                q.add(next);
                res[next] = res[node] + 1;
            }
        }

        for(int i = 1;i<=n;i++) {
            if(hideDist < res[i]) {
                hideCount = 1;
                hideDist = res[i];
                hideNum = i;
            }
            else if(hideDist == res[i]) {
                hideCount += 1;
            }
        }
    }
}