import java.io.*;
import java.util.*;

class Main {
    static Long n;
    static int k;
    static int fiveCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        n += 1;

        k = Integer.parseInt(st.nextToken());

        fiveCount = 0;
        fiveCount = checkFive();

        int idx = 0;
        while (true) {
            if (checkIdx(idx) == -1)
                break;
            idx += 1;
        }

        func();

        System.out.println(n);
    }

    public static void func() {
        int idx = 0;
        int numIdx = 9;
        while (true) {
            if (fiveCount == k)
                break;

            numIdx = checkIdx(idx);
            long tmp = (long) Math.pow(10, idx);

            if (numIdx == -1) {
                n += 5 * tmp;
                idx += 1;
                fiveCount += 1;
                continue;
            }

            if (numIdx > 5) {
                n += (10 - numIdx) * tmp;
                fiveCount = checkFive();
            } else if (numIdx == 5) {
                idx += 1;
            } else {
                n += (5 - numIdx) * tmp;
                fiveCount += 1;
            }
        }
    }

    public static int checkIdx(int idx) {
        long tmp = (long) Math.pow(10, idx);
        int numIdx = (int) ((n % (tmp * 10) - (n % tmp)) / tmp);
        if (n < tmp) {
            return -1;
        }
        return numIdx;
    }

    public static int checkFive() {
        int len = 0;
        int five = 0;
        while (true) { // '5' 개수 체크
            long tmp = (long) Math.pow(10, len);
            if ((int) (n / tmp) == 0)
                break;
            int numIdx = (int) ((n % (tmp * 10) - (n % tmp)) / tmp);

            if (numIdx == 5) {
                five += 1;
            }
            len += 1;
        }
        return five;
    }
}
