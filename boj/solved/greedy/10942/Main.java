
import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int m;
    static int[] arr;
    static int[][] res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n+1];
        for(int i = 1;i<=n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        res = new int[n+1][n+1];
        for(int i =1;i<=n;i++) {
            for(int j = i;j<=n;j++) {
                if(i == j) {
                    res[i][j] = 1;
                    continue;
                }
                for(int k = i;k<=(i+j)/2 ;k++) {
                    if(arr[k] != arr[j-(k-i)]){
                        res[i][j] = 0;
                        break;
                    }
                    res[i][j] = 1;
                }

            }
        }
        
        m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());
            sb.append(res[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] + "\n");
        }
        System.out.print(sb);
    }
}
