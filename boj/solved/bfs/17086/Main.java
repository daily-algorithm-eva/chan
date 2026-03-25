import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[][] spaces;
    static int safetyDistance = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        spaces = new int[n][m];
        for(int i = 0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<m;j++) {
                spaces[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(spaces[i][j] == 0) {
                    safetyDistance = Math.max(safetyDistance ,bfs(i, j));
                }
            }
        }
        System.out.println(safetyDistance);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        
        q.add(new int[]{x, y, 0});

        while(!q.isEmpty()) {
            int[] space = q.poll();
            int spaceX = space[0];
            int spaceY = space[1];

            if(visited[spaceX][spaceY]) {
                continue;
            }
            if(spaces[spaceX][spaceY] == 1) {
                return space[2];
            }
            visited[spaceX][spaceY] = true;
            
            List<int[]> nextSpace = new ArrayList<>();
            for(int i = -1;i<=1;i++) {
                for(int j = -1;j<=1;j++) {
                    if(i == 0 && j == 0) {
                        continue;
                    }
                    nextSpace.add(new int[]{spaceX+i , spaceY+j});
                }
            }

            for(int[] next : nextSpace) {
                if(next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m) {
                    continue;
                }
                if(visited[next[0]][next[1]]) {
                    continue;
                }
                q.add(new int[] {next[0], next[1], space[2] + 1});
            }
        }
        return -1;
    }
}