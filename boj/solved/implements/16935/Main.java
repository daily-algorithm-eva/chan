import java.io.*;
import java.util.*;

class Main {
    static int n, m, r;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            calc(Integer.parseInt(st.nextToken()));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void calc(int num) {
        int[][] tmpArr = new int[n][m];
        for (int i = 0; i < n; i++) {
            tmpArr[i] = arr[i].clone();
        }
        if (num == 1) {
            for (int i = 0; i < n; i++) {
                arr[i] = tmpArr[n - 1 - i].clone();
            }
            return;
        }
        if (num == 2) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = tmpArr[i][m - 1 - j];
                }
            }
            return;
        }
        if (num == 3) {
            int tmp = n;
            n = m;
            m = tmp;
            arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = tmpArr[m - 1 - j][i];
                }
            }
            return;
        }
        if (num == 4) {
            int tmp = n;
            n = m;
            m = tmp;
            arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = tmpArr[j][n - 1 - i];
                }
            }
            return;
        }
        if (num == 5) {
            for (int i = 0; i < n / 2; i++) {
                for (int j = m / 2; j < m; j++) {
                    arr[i][j] = tmpArr[i][j - m / 2];
                }
            }
            for (int i = n / 2; i < n; i++) {
                for (int j = m / 2; j < m; j++) {
                    arr[i][j] = tmpArr[i - n / 2][j];
                }
            }
            for (int i = n / 2; i < n; i++) {
                for (int j = 0; j < m / 2; j++) {
                    arr[i][j] = tmpArr[i][j + m / 2];
                }
            }
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < m / 2; j++) {
                    arr[i][j] = tmpArr[i + n / 2][j];
                }
            }
        }
        if (num == 6) {
            for (int i = 0; i < n / 2; i++) { // 2
                for (int j = m / 2; j < m; j++) {
                    arr[i][j] = tmpArr[i + n / 2][j];
                }
            }
            for (int i = n / 2; i < n; i++) { // 3
                for (int j = m / 2; j < m; j++) {
                    arr[i][j] = tmpArr[i][j - m / 2];
                }
            }
            for (int i = n / 2; i < n; i++) { // 4
                for (int j = 0; j < m / 2; j++) {
                    arr[i][j] = tmpArr[i - n / 2][j];
                }
            }
            for (int i = 0; i < n / 2; i++) { // 1
                for (int j = 0; j < m / 2; j++) {
                    arr[i][j] = tmpArr[i][j + m / 2];
                }
            }
        }
    }
}
