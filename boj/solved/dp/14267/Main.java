import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] parents;
    static int[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n+1];
        points = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1;i<=n;i++) {
            parents[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            points[Integer.parseInt(st.nextToken())] += Integer.parseInt(st.nextToken());
        }

        for(int i = 2;i<=n;i++) {
            points[i] += points[parents[i]];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<=n;i++) {
            sb.append(points[i] + " ");
        }

        System.out.println(sb);
    }
}