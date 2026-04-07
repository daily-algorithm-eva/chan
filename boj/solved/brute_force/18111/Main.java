import java.io.*;
import java.util.*;

class Main {
    static int n, m, b;
    static int[][] blocks;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        
        blocks = new int[n][m];
        for(int i = 0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<m;j++) {
                blocks[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 250000 * 512;
        int height = 0;

        for (int block = 0; block<=256;block++) {
            int blockNum = b;
            int time = 0;
            for(int i = 0;i<n;i++) {
                for(int j = 0;j<m;j++) {
                    if (blocks[i][j] >= block) { // 블록을 뺌
                        blockNum += blocks[i][j] - block;
                        time += 2 * (blocks[i][j] - block);
                    }
                    else {
                        blockNum -= block - blocks[i][j];
                        time += block - blocks[i][j];
                    }
                }
            }
            if (blockNum < 0) { // 더 높아봤자 블록수가 부족
                break;
            }
            if (time <= res) {
                height = block;
                res = time;
            }
        }

        System.out.println(res + " " + height);
    }
}

// 블록제거는 2초 불록 추가는 1초가 걸림 -> 가중치를 블록제거에 2배시켜야함