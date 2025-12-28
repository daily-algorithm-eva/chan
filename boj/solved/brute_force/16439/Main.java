import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 0;
        // 시간 복잡도 O(m*m*m*n) 충분.
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    int sum = 0;
                    for (int l = 0; l < n; l++) {
                        sum += Math.max(arr[l][i], Math.max(arr[l][j], arr[l][k]));
                    }
                    res = Math.max(res, sum);
                }
            }
        }

        System.out.println(res);
    }
}
