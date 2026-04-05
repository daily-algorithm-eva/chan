import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long x3 = Long.parseLong(st.nextToken());
        long y3 = Long.parseLong(st.nextToken());
        long x4 = Long.parseLong(st.nextToken());
        long y4 = Long.parseLong(st.nextToken());

        System.out.println(isIntersect(x1, y1, x2, y2, x3, y3, x4, y4) ? 1 : 0);
    }

    static boolean isIntersect(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        int res1 = ccw(x1, y1, x2, y2, x3, y3);
        int res2 = ccw(x1, y1, x2, y2, x4, y4);
        int res3 = ccw(x3, y3, x4, y4, x1, y1);
        int res4 = ccw(x3, y3, x4, y4, x2, y2);

        if (res1 * res2 <= 0 && res3 * res4 <= 0) {
            if (res1 * res2 == 0 && res3 * res4 == 0) {
                return Math.max(x1, x2) >= Math.min(x3, x4) &&
                       Math.max(x3, x4) >= Math.min(x1, x2) &&
                       Math.max(y1, y2) >= Math.min(y3, y4) &&
                       Math.max(y3, y4) >= Math.min(y1, y2);
            }
            return true;
        }
        return false;
    }

    static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long val = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
        if (val > 0) {
            return 1;
        }
        if (val < 0) {
            return -1;
        }

        return 0;
    }
}