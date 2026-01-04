import java.io.*;
import java.util.*;

class Main {
    static int k;
    static int x, y;
    static int size;
    static int[][] arr;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        size = (int) Math.pow(2, k);
        arr = new int[size + 1][size + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        arr[y][x] = -1;
        recursion(1, 1, size, y, x);

        StringBuilder sb = new StringBuilder();
        for (int i = size; i >= 1; i--) {
            for (int j = 1; j <= size; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void recursion(int row, int col, int s, int pointX, int pointY) {
        if (s == 2) {
            for (int i = 0; i < s; i++) {
                for (int j = 0; j < s; j++) {
                    if (row + i == pointX && col + j == pointY)
                        continue;
                    arr[row + i][col + j] = count;
                }
            }
            count += 1;
            return;
        } else {
            if (pointX >= row && pointX < row + s / 2 && pointY >= col && pointY < col + s / 2) { // 1사분면에 존재
                arr[row + s / 2 - 1][col + s / 2] = count;
                arr[row + s / 2][col + s / 2] = count;
                arr[row + s / 2][col + s / 2 - 1] = count;
                count += 1;
                recursion(row, col, s / 2, pointX, pointY);
                recursion(row, col + s / 2, s / 2, row + s / 2 - 1, col + s / 2);
                recursion(row + s / 2, col + s / 2, s / 2, row + s / 2, col + s / 2);
                recursion(row + s / 2, col, s / 2, row + s / 2, col + s / 2 - 1);
            }
            if (pointX >= row && pointX < row + s / 2 && pointY >= col + s / 2) { // 2사분면에 존재
                arr[row + s / 2 - 1][col + s / 2 - 1] = count;
                arr[row + s / 2][col + s / 2] = count;
                arr[row + s / 2][col + s / 2 - 1] = count;
                count += 1;
                recursion(row, col, s / 2, row + s / 2 - 1, col + s / 2 - 1);
                recursion(row, col + s / 2, s / 2, pointX, pointY);
                recursion(row + s / 2, col + s / 2, s / 2, row + s / 2, col + s / 2);
                recursion(row + s / 2, col, s / 2, row + s / 2, col + s / 2 - 1);
            }
            if (pointX >= row + s / 2 && pointY >= col + s / 2) { // 3사분면에 존재
                arr[row + s / 2 - 1][col + s / 2] = count;
                arr[row + s / 2 - 1][col + s / 2 - 1] = count;
                arr[row + s / 2][col + s / 2 - 1] = count;
                count += 1;
                recursion(row, col, s / 2, row + s / 2 - 1, col + s / 2 - 1);
                recursion(row, col + s / 2, s / 2, row + s / 2 - 1, col + s / 2);
                recursion(row + s / 2, col + s / 2, s / 2, pointX, pointY);
                recursion(row + s / 2, col, s / 2, row + s / 2, col + s / 2 - 1);
            }
            if (pointX >= row + s / 2 && pointY >= col && pointY < col + s / 2) { // 4사분면에 존재
                arr[row + s / 2 - 1][col + s / 2] = count;
                arr[row + s / 2 - 1][col + s / 2 - 1] = count;
                arr[row + s / 2][col + s / 2] = count;
                count += 1;
                recursion(row, col, s / 2, row + s / 2 - 1, col + s / 2 - 1);
                recursion(row, col + s / 2, s / 2, row + s / 2 - 1, col + s / 2);
                recursion(row + s / 2, col + s / 2, s / 2, row + s / 2, col + s / 2);
                recursion(row + s / 2, col, s / 2, pointX, pointY);
            }
        }
    }
}
