import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] matrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        for(int i =0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // matrix를 축소시켜나가면서 matrix에 저장
        for(int i = n;i>0;i/=2) {
            recursion(0, 0, n);
        }
        System.out.println(matrix[0][0]);
    }

    public static void recursion(int x, int y, int size) {
        // size가 2일경우 기존 matrix에서 1/4부분만 갱신(메모리 절약)
        if(size == 2) {
            int[] tmp = new int[]{matrix[x][y], matrix[x+1][y], matrix[x][y+1], matrix[x+1][y+1]};
            Arrays.sort(tmp);
            matrix[x/size][y/size] = tmp[2];
            return;
        }

        int halfSize = size/2;
        recursion(x, y, halfSize);
        recursion(x+halfSize, y, halfSize);
        recursion(x, y + halfSize, halfSize);
        recursion(x+halfSize, y + halfSize, halfSize);
    }
}