import java.io.*;
import java.util.*;

class Main {
    static int[][] arr;
    static int[][] matches;
    static boolean res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        arr = new int[6][3];
        matches = new int[15][2];
        int count = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                matches[count][0] = i;
                matches[count][1] = j;
                count += 1;
            }
        }
        for (int i = 0; i < 4; i++) {
            res = false;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 3; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            func(0);
            if (res) {
                sb.append(1 + " ");
            } else {
                sb.append(0 + " ");
            }
        }
        System.out.println(sb);
    }

    public static void func(int depth) {
        if (depth == 15) {
            if (check()) {
                res = true;
            }
            return;
        }
        int a = matches[depth][0];
        int b = matches[depth][1];

        // a의 승리
        if (arr[a][0] > 0 && arr[b][2] > 0) {
            arr[a][0] -= 1;
            arr[b][2] -= 1;
            func(depth + 1);
            arr[a][0] += 1;
            arr[b][2] += 1;
        }

        // b의 승리
        if (arr[a][2] > 0 && arr[b][0] > 0) {
            arr[a][2] -= 1;
            arr[b][0] -= 1;
            func(depth + 1);
            arr[a][2] += 1;
            arr[b][0] += 1;
        }

        // 무승부
        if (arr[a][1] > 0 && arr[b][1] > 0) {
            arr[a][1] -= 1;
            arr[b][1] -= 1;
            func(depth + 1);
            arr[a][1] += 1;
            arr[b][1] += 1;
        }
    }

    public static boolean check() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}