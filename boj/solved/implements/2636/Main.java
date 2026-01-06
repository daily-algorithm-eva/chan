import java.io.*;
import java.util.*;

class Main {
    static int n,m;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        int count = 0;
        while(check()!= 0) {
            int tmp = 0;
            if((tmp = check()) == 0) {
                break;
            }
            count = tmp;
            bfs();
            time +=1;
        }

        System.out.println(time);
        System.out.println(count);
    }

    public static void bfs() {
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});

        while(!q.isEmpty()) {
            int[] tmp = q.poll();

            int[][] nextLoc = new int[][]{{tmp[0]+1, tmp[1]}, {tmp[0]-1, tmp[1]}, {tmp[0], tmp[1]+1}, {tmp[0], tmp[1]-1}};

            for(int[] next : nextLoc) {
                int x = next[0];
                int y = next[1];
                if(x <0 || x >=n || y <0 || y>=m) continue;
                if(visited[x][y]) continue;

                if(map[x][y] == 1) {
                    map[x][y] = 0;
                }
                else {
                    q.add(new int[]{x,y});
                }
                visited[x][y] = true;
            }
        }
    }

    public static int check() {
        int count = 0;
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(map[i][j] == 1) {
                    count +=1;
                }
            }
        }
        return count;
    }
}