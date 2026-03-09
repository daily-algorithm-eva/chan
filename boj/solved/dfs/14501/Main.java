import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] t;
    static int[] p;
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        t = new int[n];
        p = new int[n];
        for(int i = 0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        
        recursion(0, 0);
        
        System.out.println(res);
    }

    public static void recursion(int idx, int sum) {
        if(idx > n) {
            return;
        }
        if(idx == n) {
            res = Math.max(res, sum);
            return;
        }

        recursion(idx+1, sum);
        recursion(idx+t[idx], sum+p[idx]);
    }
}