import java.io.*;
import java.util.*;

class Main {
    static int n, s;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = 0;
        int sum = 0;

        boolean check = true;
        while (sum < s) {
            if (r == n) {
                check = false;
                break;
            }
            sum += arr[r];
            r += 1;
        }
        int res = r;
        while (true) {
            while (sum - arr[l] >= s) { // 앞을 제거
                sum -= arr[l];
                l += 1;
            }

            res = Math.min(res, r - l);
            if (r == n) {
                break;
            }
            r += 1;
            sum += arr[r - 1];
        }
        if (check) {
            System.out.println(res);
        } else {
            System.out.println(0);
        }
    }
}
