import java.io.*;
import java.util.*;

class Main {
    static int[][] arr = new int[9][9];
    static boolean[][] rowVisited = new boolean[9][10];
    static boolean[][] colVisited = new boolean[9][10];
    static boolean[][] groupVisited = new boolean[9][10];
    static boolean check = false;
    static int[][] res = new int[9][9];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i = 0;i<9;i++) {
            char[] line = br.readLine().toCharArray();
            for(int j = 0;j<9;j++) {
                arr[i][j] = (int)(line[j] - '0');
                rowVisited[i][arr[i][j]] = true;
                colVisited[j][arr[i][j]] = true;
                groupVisited[3 * (int)(i / 3) + (int)(j / 3)][arr[i][j]] = true;
            }
        }
        
        recursion(0, 0);

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<9;i++) {
            for(int j = 0;j<9;j++) {
                sb.append(res[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void recursion(int x, int y) {
        if(check) {
            return;
        }
        if(x == 9) { // 끝
            check = true;
            for(int i = 0;i<9;i++) {
                res[i] = arr[i].clone();
            }
            return;
        }
        if(arr[x][y] != 0) {
            recursion(x + (int)((y+1) / 9), (y+1) % 9);
            return;
        }

        for(int i = 1;i<10;i++) {
            if(!rowVisited[x][i] && !colVisited[y][i] && !groupVisited[3 * (int)(x / 3) + (int)(y / 3)][i]) {
                rowVisited[x][i] = true;
                colVisited[y][i] = true;
                groupVisited[3 * (int)(x / 3) + (int)(y / 3)][i] = true;
                arr[x][y] = i;
                recursion(x + (int)((y+1) / 9), (y+1) % 9);
                rowVisited[x][i] = false;
                colVisited[y][i] = false;
                groupVisited[3 * (int)(x / 3) + (int)(y / 3)][i] = false;
                arr[x][y] = 0;
            }
        }
    }
}
