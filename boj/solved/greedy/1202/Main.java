import java.io.*;
import java.util.*;

class Main {
    static int n, k;
    static Integer[][] juwels;
    static Integer[] weights;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        juwels = new Integer[n][2];
        weights = new Integer[k];
        visited = new boolean[k];

        for(int i = 0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            juwels[i][0] = m;
            juwels[i][1] = k;
        }
        Arrays.sort(juwels, Comparator.comparing(a -> a[0]));

        for(int i = 0;i<k;i++) {
            weights[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(weights);

        PriorityQueue<Integer[]> pq = new PriorityQueue<>(Comparator.comparing(a -> -a[1]));

        int juwelIdx = 0;
        long res = 0;
        for(int i = 0;i<k;i++) {
            while(juwelIdx < n && juwels[juwelIdx][0] <= weights[i]) {
                pq.add(juwels[juwelIdx]);
                juwelIdx +=1;
            }
            if (!pq.isEmpty()) {
                res += pq.poll()[1];
            }
        }

        System.out.println(res);
    }
}