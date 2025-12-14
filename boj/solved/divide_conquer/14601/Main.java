import java.io.*;
import java.util.*;

class Main {
    static int k;
    static int r;
    static int X,Y;
    static int[][] arr;
    static int maxTile;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        X  = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        r = (int)Math.pow(2, k);
        maxTile = (r*r-1)/3;

        arr = new int[r][r];

        arr[Y-1][X-1] = -1; // 배수구

        recursion(0, 0, r, 1, new int[]{Y-1,X-1});
        boolean possible = true;
        for(int i = r-1;i>=0;i--) {
            for(int j = 0;j<r;j++) {
                if(arr[i][j] == 0) possible = false;
            }
        }
        if(possible) {
            for(int i = r-1;i>=0;i--) {
                for(int j = 0;j<r;j++) {
                    sb.append(arr[i][j] + " ");
                }
                sb.append("\n");
            }
        }
        else{
            sb.append("-1\n");
        }
        System.out.print(sb);
    }

    public static void recursion(int x, int y, int size, int count, int[] blank) {
        int blankX = blank[0];
        int blankY = blank[1];
        if(size == 2) {
            arr[x][y] = arr[x][y] == 0 ? count : arr[x][y];
            arr[x+1][y] =arr[x+1][y] == 0 ? count : arr[x+1][y];
            arr[x][y+1] = arr[x][y+1] == 0 ? count : arr[x][y+1];
            arr[x+1][y+1] = arr[x+1][y+1] == 0 ? count : arr[x+1][y+1];
            return;
        }
        
        int tmp = (size*size-1)/3-1; // count ~ count+tmp 1~5 1~1 2~2 3~3 4~4
        int check = 0;
        if(blankX >=x && blankX <x + size/2 && blankY >=y && blankY < y+size/2){ // 1사분면에 빈값존재
            check = 1;
            recursion(x, y, size/2, count, blank);
        }
        else{
            recursion(x, y, size/2, count, new int[]{x+size/2-1, y+size/2-1});
        }

        if(blankX >=x && blankX <x + size/2 && blankY >=y+size/2){ // 2사분면에 빈값존재
            check = 2;
            recursion(x, y + size/2, size/2, count + tmp/4, blank);
        }
        else{
            recursion(x, y + size/2, size/2, count + tmp/4, new int[]{x+size/2-1, y+size/2});
        }
        
        if(blankX >=x + size/2 && blankY >=y && blankY < y+size/2){ // 4사분면에 빈값존재
            check = 4;
            recursion(x+size/2, y, size/2, count+ 2*tmp/4, blank); 
        }
        else{
            recursion(x+size/2, y, size/2, count+ 2*tmp/4, new int[]{x+size/2, y+size/2-1}); 
        }
        
        if(blankX >=x + size/2 && blankY >=y+size/2){ // 3사분면에 빈값존재
            check = 3;
            recursion(x+size/2, y+size/2, size/2, count + 3*tmp/4, blank);
        }
        else{
            recursion(x+size/2, y+size/2, size/2, count + 3*tmp/4, new int[]{x+size/2, y+size/2});
        }

        if(check != 1) {
            arr[x+size/2-1][y+size/2-1] = count+tmp; // 1
        }
        if(check != 2) {
            arr[x+size/2-1][y+size/2] = count+tmp; // 2
        }
        if(check != 3) {
            arr[x+size/2][y+size/2] = count+tmp; // 3
        }
        if(check != 4) {
            arr[x+size/2][y+size/2-1] = count+tmp; // 4
        }
    }
}