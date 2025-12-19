import java.io.*;
import java.util.*;

class Main {
    static int[][] domino;
    static boolean[][] visitedDomino;
    static boolean[][] visitedDice;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        visitedDice = new boolean[7][7];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (i <= j)
                    continue;
                visitedDice[i][j] = true;
            }
        }

        domino = new int[8][7];
        visitedDomino = new boolean[8][7];
        for (int i = 0; i < 8; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < 7; j++) {
                domino[i][j] = arr[j] - '0';
            }
        }

        dfs(0, 0);
        System.out.println(count);
    }

    public static void dfs(int x, int y) {
        if (x == 8) {
            count += 1;
            return;
        }
        if (visitedDomino[x][y]) {
            if (y == 6)
                dfs(x + 1, 0);
            else
                dfs(x, y + 1);
            return;
        }
        int dice1 = domino[x][y];
        int[][] nextDice = new int[][] { { x, y + 1 }, { x + 1, y } };

        for (int[] next : nextDice) {
            int a = next[0];
            int b = next[1];
            if (a > 7 || b > 6)
                continue;
            if (visitedDomino[a][b])
                continue;
            int dice2 = domino[a][b];

            int u = Math.min(dice1, dice2);
            int v = Math.max(dice1, dice2);

            if (!visitedDice[u][v]) {
                visitedDice[u][v] = true;

                visitedDomino[x][y] = true;
                visitedDomino[a][b] = true;

                if (y == 6)
                    dfs(x + 1, 0);
                else
                    dfs(x, y + 1);

                visitedDice[u][v] = false;
                visitedDomino[x][y] = false;
                visitedDomino[a][b] = false;
            }
        }
    }

    public static boolean check() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                if (!visitedDomino[i][j])
                    return false;
            }
        }
        return true;
    }
}