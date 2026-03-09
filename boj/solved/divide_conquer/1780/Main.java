import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] arr;
    static int[] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        res = new int[3]; // 0 : -1 1
        for(int i = 0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0,0,n);

        for(int i = 0;i<3;i++) {
            System.out.println(res[i]);
        }
    }

    public static void recursion(int x, int y, int size) {
        int last = arr[x][y];
        boolean check = true;
        for(int i = x;i<x+size;i++) {
            for(int j = y;j<y+size;j++) {
                if(arr[i][j] != last) {
                    check =false;
                    break;
                }
            }
        }

        if(check) {
            res[last+1] +=1;
            return;
        }
        
        for(int i = 0;i<3;i++) {
            for(int j = 0;j<3;j++) {
                recursion(x+ i*(size/3), y+j*(size/3), size/3);
            }
        }
    }
}