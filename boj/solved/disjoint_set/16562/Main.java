import java.io.*;
import java.util.*;

class Main {
    static int n, m, k;
    static int[] w;
    static int[] friends;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        friends = new int[n+1];
        w = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1;i<=n;i++) {
            friends[i] = i;
            w[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        int res = 0;
        for(int i = 1;i<=n;i++) {
            if(find(i) == i) {
                res += w[i];
            }
        }

        if (res > k) {
            System.out.println("Oh no");
        }
        else {
            System.out.println(res);
        }
    }

    public static int find(int id) {
        if (friends[id] == id) {
            return id;
        }
        return friends[id] = find(friends[id]);
    }

    public static void union(int a, int b) {
        int friendA = find(a);
        int friendB = find(b);
        if (friendA == friendB) {
            return;
        }

        if (w[friendA] > w[friendB]) {
            friends[friendA] = friendB;
        }
        else {
            friends[friendB] = friendA;
        }
    }
}