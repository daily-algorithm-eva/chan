import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] nw;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nw = new int[n];
        for(int i = 0; i < n; i++) {
            nw[i] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[n + 1][80001]; 
        
        recursion(0, 0);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(visited[n][tmp + 40000]) {
                sb.append("Y ");
            }
            else {
                sb.append("N ");
            }
        }
        System.out.println(sb);
    }

    public static void recursion(int idx, int sum) {
        if(visited[idx][sum + 40000]) return;
        
        visited[idx][sum + 40000] = true;
        
        if(idx == n) return;
        
        recursion(idx + 1, sum + nw[idx]); 
        recursion(idx + 1, sum - nw[idx]);
        recursion(idx + 1, sum);
    }
}