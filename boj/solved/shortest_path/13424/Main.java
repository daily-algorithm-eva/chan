import java.io.*;
import java.util.*;

class Main {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());
        while(t-- >0) {
            // init
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] distance = new int[n+1][n+1];
            for(int i = 0;i<=n;i++) {
                Arrays.fill(distance[i], 100001);
                distance[i][i] = 0;
            }
            for(int i = 0;i<m;i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                distance[start][end] = w;
                distance[end][start] = w;
            }
            int k = Integer.parseInt(br.readLine());
            int[] people = new int[k];
            st = new StringTokenizer(br.readLine());
            for(int i = 0;i<k;i++) {
                people[i] = Integer.parseInt(st.nextToken());
            }
            
            // 노드 간 최단 거리 계산
            for(int i = 1;i<=n;i++) {
                for(int j = 1;j<=n;j++) {
                    for(int l = 1;l<=n;l++) {
                        if(j == i || l == i) {
                            continue;
                        }
                        if(distance[j][l] > distance[j][i] + distance[i][l]) {
                            distance[j][l] = distance[j][i] + distance[i][l];
                            distance[l][j] = distance[j][i] + distance[i][l];
                        }
                    }
                }
            }
            
            // 최소 이동거리 총합 계산
            int res = 10000001;
            int idx = 0;
            for(int i = 1;i<=n;i++) {
                int sum = 0;
                for(int tmp : people) {
                    sum += distance[i][tmp];
                }
                if(res > sum) {
                    res = sum;
                    idx = i;
                }
            }
            sb.append(idx + "\n");
        }

        System.out.print(sb);
    }
}