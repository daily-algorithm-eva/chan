import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] arr;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        check = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                check[i] = true;
            }
        }
        int count = 0;
        while (true) {
            boolean a = false;
            for (int i = 0; i < n; i++) {
                if (check[i])
                    continue;
                if (arr[i] == 1) {
                    count += 1;
                    check[i] = true;
                    arr[i] = 0;
                    continue;
                }
                a = true;

                if (arr[i] % 2 == 1) {
                    arr[i] -= 1;
                    count += 1;
                } 
                arr[i] /= 2;
                
            }
            if(a) {
                count +=1;
            }
            else{
                break;
            }
        }
        System.out.println(count);
    }
}