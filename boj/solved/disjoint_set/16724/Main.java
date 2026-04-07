import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static char[][] map;
    static int[][][] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        parents = new int[n][m][2];

        for(int i = 0;i<n;i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0;j<m;j++) {
                parents[i][j][0] = i;
                parents[i][j][1] = j;
            }
        }
        
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(map[i][j] == 'U') {
                    union(new int[]{i, j}, new int[]{i-1, j});
                }
                if(map[i][j] == 'D') {
                    union(new int[]{i, j}, new int[]{i+1, j});
                }
                if(map[i][j] == 'L') {
                    union(new int[]{i, j}, new int[]{i, j-1});
                }
                if(map[i][j] == 'R') {
                    union(new int[]{i, j}, new int[]{i, j+1});
                }
            }
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0;i<n;i++) {
            for(int j= 0 ;j<m;j++) {
                int[] node = find(i,j);
                hs.add(node[0] * m + node[1]);
            }
        }

        System.out.println(hs.size());
    }

    public static void union(int[] first, int[] next) {
        int[] parentFirst = find(first[0], first[1]);
        int[] parentNext = find(next[0], next[1]);

        parents[parentFirst[0]][parentFirst[1]][0] = parentNext[0];
        parents[parentFirst[0]][parentFirst[1]][1] = parentNext[1];
    }

    public static int[] find(int nodeX, int nodeY) {
        if(parents[nodeX][nodeY][0] == nodeX && parents[nodeX][nodeY][1] == nodeY) {
            return new int[]{nodeX, nodeY};
        }

        return parents[nodeX][nodeY] = find(parents[nodeX][nodeY][0], parents[nodeX][nodeY][1]);
    }
}


