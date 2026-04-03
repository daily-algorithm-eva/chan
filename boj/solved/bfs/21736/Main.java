import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static char[][] campus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        campus = new char[n][m];

        for(int i = 0;i<n;i++) {
            campus[i] = br.readLine().toCharArray();
        }

        int doyeonX = 0;
        int doyeonY = 0;
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(campus[i][j] == 'I') {
                    doyeonX = i;
                    doyeonY = j;
                    break;
                }
            }
        }

        int count = bfs(doyeonX, doyeonY);
        if (count == 0) {
            System.out.println("TT");
        }
        else {
            System.out.println(count);
        }
    }

    public static int bfs(int startX, int startY) {
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        int res = 0;
        q.add(new int[]{startX, startY});
        while(!q.isEmpty()) {
            int[] loc = q.poll();
            int locX = loc[0];
            int locY = loc[1];
            if (visited[locX][locY]) {
                continue;
            }
            if (campus[locX][locY] == 'X') {
                visited[locX][locY] = true;
                continue;
            }
            if (campus[locX][locY] == 'P') {
                res +=1;
            }

            visited[locX][locY] = true;
            int[][] nextLoc = new int[][]{{locX + 1, locY}, {locX - 1, locY}, {locX, locY + 1}, {locX, locY - 1}};

            for(int[] next : nextLoc) {
                if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= m) {
                    continue;
                }
                if(visited[next[0]][next[1]]) {
                    continue;
                }
                q.add(new int[]{next[0], next[1]});
            }
        }

        return res;
    }
}