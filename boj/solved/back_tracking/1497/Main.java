import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int res = 11;
    static int song = 0;
    static boolean[][] arr;
    static boolean possible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            char[] tmp = st.nextToken().toCharArray();
            boolean[] possible = new boolean[m];
            for (int j = 0; j < m; j++) {
                if (tmp[j] == 'Y') {
                    possible[j] = true;
                } else {
                    possible[j] = false;
                }
            }
            arr[i] = possible;
        }

        func(0, new boolean[m], 0, 0);

        if (!possible) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

    public static void func(int idx, boolean[] possibleSongs, int gitar, int count) {
        if (song < count) {
            song = count;
            res = gitar;
        } else if (song == count) {
            res = Math.min(res, gitar);
        }
        if (idx == n) {
            return;
        }

        func(idx + 1, possibleSongs.clone(), gitar, count); // 포함 안 할 경우
        int tmp = 0;
        for (int i = 0; i < m; i++) {
            if (arr[idx][i] && !possibleSongs[i]) {
                possible = true;
                possibleSongs[i] = true;
                tmp += 1;
            }
        }
        func(idx + 1, possibleSongs.clone(), gitar + 1, count + tmp);
    }
}