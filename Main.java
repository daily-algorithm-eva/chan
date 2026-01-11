import java.io.*;
import java.util.*;

class Main {
    static int R,C,N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[R][C]; // -1은 폭탄 미설치 0은 설치 2이되면 터짐
        for(int i = 0;i<R;i++) {
            char[] tmp = br.readLine().toCharArray();
            for(int j = 0;j<C;j++) {
                if(tmp[j] == '.') {
                    arr[i][j] = -1;
                }
                if(tmp[j] == 'O') {
                    arr[i][j] = 0;
                }
            }
        }
        N -=1;
        oneTime();
        while(true) {
            if(N == 0) break;
            oneTime();
            setting();
            N -=1;
            if(N == 0) break;
            oneTime();
            booom();
            N -=1;
            if(N == 0) break;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<R;i++) {
            for(int j = 0;j<C;j++) {
                if(arr[i][j] == -1) {
                    sb.append(".");
                }
                else {
                    sb.append("O");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
    public static void oneTime() {
        for(int i = 0;i<R;i++) {
            for(int j = 0;j<C;j++) {
                if(arr[i][j] != -1) {
                    arr[i][j] += 1;
                }
            }
        }
    }

    public static void setting() {
        for(int i = 0;i<R;i++) {
            for(int j = 0;j<C;j++) {
                if(arr[i][j] == -1) {
                    arr[i][j]  = 0;
                }
            }
        }
    }
    public static void booom() {

        for(int i = 0;i<R;i++) {
            for(int j = 0;j<C;j++) {
                if(arr[i][j] >= 0) {
                    if(arr[i][j] == 3) {
                        int[][] next = new int[][]{{i+1, j}, {i-1, j}, {i, j+1}, {i, j-1}};
                        for(int[] tmp : next) {
                            if(tmp[0] < 0 || tmp[0] >= R || tmp[1] < 0 || tmp[1] >=C) {
                                continue;
                            }
                            if(arr[tmp[0]][tmp[1]] == 3) {
                                continue;
                            }
                            arr[tmp[0]][tmp[1]] = -1;
                        }
                        arr[i][j] = -1;
                    }
                }
            }
        }
    }
}



// 0 설치
// 1  -
// 2 설치
// 3 1 펑
// 4 설치
// 5 2 펑
// 6 설치
