import java.io.*;
import java.util.*;

class Main {
    static int T;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        while(T-->0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            boolean[][] map = new boolean[n+1][n+1]; // i가 j를 이기는가
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0;i<n;i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 0;i<n;i++) {
                for(int j = i+1;j<n;j++) {
                    map[arr[i]][arr[j]] = true;
                }
            }
            int m = Integer.parseInt(br.readLine());
            
            boolean impossible = false; // imposiible
            for(int i = 0;i<m;i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(map[a][b]) {
                    map[a][b] = false;
                    map[b][a] = true;
                }
                else{
                    map[a][b] = true;
                    map[b][a] = false;
                }
            }

            int[] res = new int[n];
            for(int i = 1;i<=n;i++) {
                int count = 0;
                for(int j = 1;j<=n;j++) {
                    if(!map[i][j]) count +=1;
                }
                res[count-1] = i;
            }
            
            boolean check = false;
            for(int i = 0;i<n;i++) {
                if(res[i] == 0) {
                    check = true;
                }
            }
            if(check) {
                sb.append("IMPOSSIBLE\n");
                continue;
            }
            
            for(int i = 0;i<n;i++) {
                sb.append(res[i] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}

