import java.io.*;
import java.util.*;

class Main {
    static List<Integer> arr;
    static int power = 0;
    static int[][][] dp; // i번쨰일때 (j,k)에 발을 딛을떄

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new ArrayList<>();
        int tmp;
        while ((tmp = Integer.parseInt(st.nextToken())) != 0) {
            arr.add(tmp);
        }
        int size = arr.size();
        dp = new int[size + 1][5][5]; // 1600000 * 4bytes
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], 400000);
            }
        }
        dp[0][0][0] = 0;
        for (int i = 1; i <= size; i++) {
            int point = arr.get(i - 1); // 다음 발의 위치

            for (int j = 0; j < 5; j++) {
                if(j == point) {
                    continue;
                }
                func(i, j, point);
            }
        }

        int res = 400000;
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                res = Math.min(res, dp[size][i][j]);
            }
        }

        System.out.println(res);
    }

    public static void func(int idx, int fixedNum, int point) {
        int min = 400000;
        // k 가 고정될 경우
        for (int j = 0; j <= 4; j++) {
            if (point == j) { // 1
                min = Math.min(min, dp[idx - 1][j][fixedNum] + 1);
                continue;
            }
            if (j == 0) { // 2
                min = Math.min(min, dp[idx - 1][j][fixedNum] + 2);
                continue;
            }
            if ((point + j) % 2 == 1) { // 3
                min = Math.min(min, dp[idx - 1][j][fixedNum] + 3);
                continue;
            }
            min = Math.min(min, dp[idx - 1][j][fixedNum] + 4);
        }
        dp[idx][point][fixedNum] = min;
        dp[idx][fixedNum][point] = min;
    }
}
// 1 2 - 0
// 1 3 - 1
// 1 4 - 2
// 2 3 - 3
// 2 4 - 4
// 3 4 - 5
