import java.io.*;
import java.util.*;

class Main {
    static int h, w, n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(br.readLine());
        arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp1 = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());
            if (tmp1 > tmp2) {
                arr[i][0] = tmp2;
                arr[i][1] = tmp1;
            } else {
                arr[i][1] = tmp2;
                arr[i][0] = tmp1;
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                boolean check = false;
                // 첫번쨰가 그대로
                if (arr[i][0] <= h && arr[i][1] <= w) { // (h-arr[i][0], w) (h, w-arr[i][1])
                    if (arr[j][0] <= h - arr[i][0] && arr[j][1] <= w) {
                        check = true;
                    }
                    if (arr[j][0] <= h && arr[j][1] <= w - arr[i][1]) {
                        check = true;
                    }
                    if (arr[j][1] <= h - arr[i][0] && arr[j][0] <= w) {
                        check = true;
                    }
                    if (arr[j][1] <= h && arr[j][0] <= w - arr[i][1]) {
                        check = true;
                    }
                }

                // 첫번쨰가 회전
                if (arr[i][0] <= w && arr[i][1] <= h) { // (w-arr[i][0], h) (w, h-arr[i][0])
                    if (arr[j][0] <= w - arr[i][0] && arr[j][1] <= h) {
                        check = true;
                    }
                    if (arr[j][0] <= w && arr[j][1] <= h - arr[i][1]) {
                        check = true;
                    }
                    if (arr[j][1] <= w - arr[i][0] && arr[j][0] <= h) {
                        check = true;
                    }
                    if (arr[j][1] <= w && arr[j][0] <= h - arr[i][1]) {
                        check = true;
                    }
                }
                if (check) {
                    res = Math.max(res, arr[i][0] * arr[i][1] + arr[j][0] * arr[j][1]);
                }
            }
        }
        System.out.println(res);
    }
}