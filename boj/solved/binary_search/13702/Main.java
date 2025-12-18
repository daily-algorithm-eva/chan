import java.io.*;
import java.util.*;

class Main {
    static int n, k;
    static int[] arr;
    static long res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long left = 1;
        long right = arr[n - 1];
        while (left <= right) {
            long mid = (left + right) / 2;

            if (calc(mid) >= k) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(res);
    }

    public static long calc(long num) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i] / num;
        }
        return sum;
    }
}