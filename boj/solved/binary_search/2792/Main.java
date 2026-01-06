import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int res = 1000000001;
        int front = 1;
        int near = arr[m - 1];
        while (front <= near) {
            int mid = (front + near) / 2;
            if (check(mid)) {
                front = mid + 1;
            } else {
                res = Math.min(res, mid);
                near = mid - 1;
            }
        }
        System.out.println(res);
    }

    public static boolean check(int num) {
        int childrenNum = 0;
        for (int i = 0; i < m; i++) {
            if (arr[i] % num == 0) {
                childrenNum += arr[i] / num;
            } else {
                childrenNum += arr[i] / num + 1;
            }
        }

        if (childrenNum > n) { // 더많은 아이들에게 나눠줄수있음 -> 개수를 키워야함
            return true;
        }
        return false; // 개수를 줄여야함
    }
}
