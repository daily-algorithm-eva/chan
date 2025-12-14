import java.io.*;
import java.util.*;

class Main {
    static int n;
    static long w;
    static long coin = 0;
    static int[] arr;
    static int[] check; //0 유지 1 감소 2 증가
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        arr = new int[n];
        check = new int[n];
        for(int i =0;i<n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = 0;i<n-1;i++) {
            if(arr[i] < arr[i+1]) {
                check[i] = 2;
            }
            else if(arr[i] > arr[i+1]) {
                check[i] = 1;
            }
            else{
                check[i] = 0;
            }
        }

        for(int i = 0;i<n-1;i++) {
            if(check[i] == 2) { // 구매
                long tmp = (long)w / arr[i];
                coin += tmp;
                w = w % arr[i];
            }
            else if(i>0 && check[i] == 1 && check[i-1] != 1) { // 판매
                w += coin * arr[i];
                coin = 0;
            }
        }
        w += coin * arr[n-1];
        System.out.println(w);
    }
}