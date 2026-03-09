import java.io.*;
import java.util.*;

class Main {
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-->0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int[][] CU = new int[n][2];
            for(int i = 0;i<n;i++) {
                st = new StringTokenizer(br.readLine());
                CU[i][0] = Integer.parseInt(st.nextToken());
                CU[i][1] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{startX, startY});
            boolean[] visited = new boolean[n];
            boolean res = false;
            while(!q.isEmpty()) {
                int[] point = q.poll();
                
                if(Math.abs(point[0] - endX) + Math.abs(point[1]- endY) <= 1000) {
                    res = true;
                    break;
                }
                for(int i = 0;i<n;i++) {
                    if(visited[i]) {
                        continue;
                    }
                    if(Math.abs(point[0] - CU[i][0]) + Math.abs(point[1]- CU[i][1]) <= 1000) {
                        q.add(CU[i]);
                        visited[i] = true;
                    }
                }
            }

            if(res) {
                sb.append("happy\n");
            }
            else {
                sb.append("sad\n");
            }
        }

        System.out.print(sb);
    }
}