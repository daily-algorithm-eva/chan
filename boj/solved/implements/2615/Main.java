import java.io.*;
import java.util.*;

class Main {
    static int[][] map;
    static int res = 0;
    static int[] point;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[19][19];

        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean isEnd = false;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] == 0)
                    continue;
                isEnd = func(i, j);
                if (isEnd) {
                    res = map[i][j];
                    point = new int[] { i + 1, j + 1 };
                    break;
                }
            }
            if (isEnd)
                break;
        }

        if (res == 0) {
            System.out.println(0);
        } else {
            System.out.println(res);
            System.out.println(point[0] + " " + point[1]);
        }
    }

    public static boolean func(int row, int col) {
        // (row, col + 1) (row+1, col +1) (row +1, col) (row-1, col+1)
        int check = map[row][col];
        boolean isEnd = false;
        for (int i = 1; i < 5; i++) {
            if (col + i >= 19 || map[row][col + i] != check) {
                isEnd = false;
                break;
            }
            isEnd = true;
        }
        if (col + 5 < 19 && map[row][col + 5] == check) {
            isEnd = false;
        }
        if(col-1 >=0 && map[row][col-1] == check) {
            isEnd = false;
        }
        if (isEnd)
            return true;

        for (int i = 1; i < 5; i++) {
            if (row + 1 >= 19 || col + i >= 19 || map[row + i][col + i] != check) {
                isEnd = false;
                break;
            }
            isEnd = true;
        }
        if (row + 5 < 19 && col + 5 < 19 && map[row + 5][col + 5] == check) {
            isEnd = false;
        }
        if(row-1>=0 && col-1 >=0 && map[row-1][col-1] == check) {
            isEnd = false;
        }
        if (isEnd)
            return true;

        for (int i = 1; i < 5; i++) {
            if (row + i >= 19 || map[row + i][col] != check) {
                isEnd = false;
                break;
            }
            isEnd = true;
        }
        if (row + 5 < 19 && map[row + 5][col] == check) {
            isEnd = false;
        }
        if(row-1>=0  && map[row-1][col] == check) {
            isEnd = false;
        }
        if (isEnd)
            return true;

        for (int i = 1; i < 5; i++) {
            if (row - i < 0 || col + i >= 19 || map[row - i][col + i] != check) {
                isEnd = false;
                break;
            }
            isEnd = true;
        }
        if (row - 5 >= 0 && col + 5 < 19 && map[row - 5][col + 5] == check) {
            isEnd = false;
        }
        if(col-1 >=0 && row+1<19  && map[row+1][col-1] == check) {
            isEnd = false;
        }
        if (isEnd)
            return true;

        return false;
    }
}