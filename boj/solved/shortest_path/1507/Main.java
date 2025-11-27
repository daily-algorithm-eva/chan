import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] shortest_dist;
    static boolean imposible = false;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        shortest_dist = new int[n+1][n+1];

        for(int i =1;i<=n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =1;j<=n;j++) {
                shortest_dist[i][j] = Integer.parseInt(st.nextToken());
                res += shortest_dist[i][j];
                
            }
        }
        res /= 2; // 거리의 합의 최대 값
        for(int i =1;i<=n;i++) {
            for(int j =i+1;j<=n;j++) {
                for(int k =1;k<=n;k++) {
                    if(k == i || k == j) continue;
                    if(shortest_dist[i][k] + shortest_dist[k][j] == shortest_dist[i][j]) { // 중간에 거치는 거리와 같으면 뺌
                        res -= shortest_dist[i][j];
                        break;
                    }
                    else if(shortest_dist[i][k] + shortest_dist[k][j] < shortest_dist[i][j]) { // 최단 거리가 성립하지 않음
                        imposible = true;
                    }
                }
            }
        }
        if(imposible) {
            System.out.println(-1);
        }
        else{
            System.out.println(res);
        }
    }
}