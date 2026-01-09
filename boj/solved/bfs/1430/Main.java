import java.io.*;
import java.util.*;

class Main {
    static int N,R,D,X,Y;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        R = R*R; // 거리는 제곱으로 계산

        arr = new int[N][2];

        for(int i = 0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }

        System.out.println(bfs(new int[]{X, Y, 0}));
    }

    public static double bfs(int[] point) {
        Queue<int[]> q = new LinkedList<>();
        int[] depth = new int[N];
        Arrays.fill(depth, 52);
        q.add(point);
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int tmpX = tmp[0];
            int tmpY = tmp[1];

            for(int i = 0;i<N;i++) {
                if(depth[i] <= tmp[2]+1) continue;
                if((arr[i][0] - tmpX) * (arr[i][0] - tmpX) + (arr[i][1] - tmpY)* (arr[i][1] - tmpY) <= R) {
                    q.add(new int[]{arr[i][0], arr[i][1], tmp[2]+1});
                    depth[i] = tmp[2];
                }
            }
        }
        double res = 0;
        for(int i = 0;i<N;i++) {
            if(depth[i] == 52) continue;
            res += D / Math.pow(2, depth[i]);
        }
        return res;
    }
}