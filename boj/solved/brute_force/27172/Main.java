import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] arr;
    static boolean[] isExists;
    static int[] res;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        isExists = new boolean[10000001];
        res = new int[10000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            isExists[arr[i]] = true;
        }
        
        for(int i = 0;i<n;i++) {
            int tmp = arr[i];
            
            for(int j = tmp * 2;j < 10000001;j += tmp) {
                if(isExists[j]) {
                    res[tmp] +=1;
                    res[j] -=1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++) {
            sb.append(res[arr[i]] + " ");
        }
        System.out.println(sb);

    }
}
