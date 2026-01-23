import java.io.*;
import java.util.*;

class Main {
    static long n;
    static int m;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        st = new StringTokenizer(br.readLine());

        int big = 0;
        for(int i = 0;i<m;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            big = Math.max(big, arr[i]);
        }
        
        long l = 0;
        long r = 2000000000L*big;
        long point = 0; // 시간
        while(l <= r) {
            long mid = (l+r)/2;
            long tmp = func(mid);

            if(tmp >= n) { // mid 줄임
                point = mid;
                r = mid-1;
            }
            else {
                l = mid+1;
            }
        }
        long remain = n-func(point-1); // 마지막에 남아있는 사람
        int res = 0;
        for(int i = 0;i<m;i++) {
            if(point % arr[i] == 0) {
                res = i+1;
                remain -=1;
            }
            if(remain == 0) {
                break;
            }
        }
        if(n <= m) {
            System.out.println(n);
        }
        else {
            System.out.println(res);
        }
    }

    public static long func(long num) {
        long sum = 0;
        for(int tmp : arr) {
            sum += (long)(num / tmp) + 1;
        }
        return sum;
    }
}
// 몇초에 몇명 탈까 
// 같은 시간에 우루루 탈수도 있음

// 7 2
// 3 2

// 0 : 3 2 
// 2 : 2
// 3 : 3
// 4 : 2
// 6 : 3 2
