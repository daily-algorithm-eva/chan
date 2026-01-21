import java.io.*;
import java.util.*;

class Main {
    static int n;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        int front = 0;
        int near = n - 1;
        long res = 2000000001;
        long a = 0;
        long b = 0;

        while (front < near) {
            long tmp = arr[front] + arr[near];
            if (Math.abs(tmp) < Math.abs(res)) {
                a = arr[front];
                b = arr[near];
                res = tmp;
            }

            if (tmp > 0) {
                near -= 1;
            } else {
                front += 1;
            }
        }

        System.out.println(a + " " + b);
    }
}