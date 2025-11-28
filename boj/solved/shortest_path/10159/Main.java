import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int m;
    static int[][] twinsObjects;
    static char[][] arr; // 비교 표
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        twinsObjects = new int[m][2];
        arr = new char[n+1][n+1];
        for(int i = 0;i<=n;i++) {
            Arrays.fill(arr[i], 'n');
        }

        for(int i =0;i<m;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int big = Integer.parseInt(st.nextToken());
            int small = Integer.parseInt(st.nextToken());
            arr[big][small] = 'b';
            arr[small][big] = 's';
        }

        for(int k = 1;k<=n;k++) {
            for(int i =1;i<=n;i++) {
                for(int j =1;j<=n;j++) {
                    if(i == j) continue;
                    if(k == i || k ==j) continue;
                    if(arr[i][k] == 'b' && arr[k][j] == 'b') {
                        arr[i][j] = 'b';
                    }
                    if(arr[i][k] == 's' && arr[k][j] == 's') {
                        arr[i][j] = 's';
                    }
                }
            }
        }

        for(int i =1;i<=n;i++) {
            int count = 0;
            for(int j =1;j<=n;j++) {
                if(i == j) continue;
                if(arr[i][j] == 'n') {
                    count +=1;
                } 
            }
            System.out.println(count);
        }
    }
}