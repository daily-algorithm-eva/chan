import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] arr;
    static boolean[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new boolean[2000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        recursion(0,0);

        int i = 0;
        for(i = 0;i<2000001;i++) {
            if(!dp[i]) {
                break;
            }
        }
        System.out.println(i);
    }

    public static void recursion(int idx, int sum) { 
        dp[sum] = true;
        if(idx == n) return;
        recursion(idx+1, sum + arr[idx]);
        recursion(idx+1, sum);
    }
}