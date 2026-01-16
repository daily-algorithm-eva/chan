import java.io.*;
import java.util.*;

class Main {
    static int n;
    static long[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n =Integer.parseInt(br.readLine());
        arr = new long[n+1][2];

        for(int i = 0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }
        arr[n][0] = arr[0][0];
        arr[n][1] = arr[0][1];

        long res = 0;
        for(int i = 0;i<n;i++) {
            res += arr[i][0] * arr[i+1][1];
            res -= arr[i][1] * arr[i+1][0];
        }
        System.out.printf("%.1f\n", Math.abs(res) / 2.0);
    }
}