import java.io.*;
import java.util.*;

class Main {
    static int n,m;
    static int[][] arr;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m][2];
        parents = new int[n];
        for(int i = 0;i<n;i++) {
            parents[i] = i;
        }
        
        for(int i = 0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        
        int res = 0;
        for(int i = 0;i<m;i++) {
            if(union(arr[i][0], arr[i][1])) {
                res = i+1;
                break;
            }
        }

        System.out.println(res);
    }

    public static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);
        if(parentA == parentB) {
            return true;
        }

        parents[parentA] = parentB;
        return false;
    }

    public static int find(int num) {
        if(parents[num] == num) {
            return num;
        }
        
        return parents[num] = find(parents[num]);
    }
}