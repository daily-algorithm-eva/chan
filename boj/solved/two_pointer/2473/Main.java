import java.io.*;
import java.util.*;

class Main {
    static int n;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long sum = 5000000000001L;
        long[] res = new long[3];
        for (int k = 0; k < n; k++) { // 고정적 하나 선택 후 이분 탐색
            int front = 0;
            int near = n - 1;
            while (front < near) {
                if (front == k) {
                    front += 1;
                    continue;
                }
                if (near == k) {
                    near -= 1;
                    continue;
                }
                long tmp = arr[k] + arr[front] + arr[near]; // 임시 합계
                if (Math.abs(sum) > Math.abs(tmp)) {
                    sum = tmp;
                    res = new long[] { arr[k], arr[front], arr[near] };
                }

                if (tmp > 0) {
                    near -= 1;
                } else if (tmp < 0) {
                    front += 1;
                } else {
                    break;
                }
            }
        }
        Arrays.sort(res);
        System.out.println(res[0] + " " + res[1] + " " + res[2]);
    }
}
