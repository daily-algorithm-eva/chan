import java.io.*;
import java.util.*;

class Main {
    static int n, m, l;
    static int[] s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        s = new int[m];
        for(int i = 0;i<m;i++) {
            s[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++) {
            int tmp = binarySearch(Integer.parseInt(br.readLine()));
            sb.append(tmp + "\n");
        }

        System.out.print(sb);
    }

    public static int binarySearch(int q) {
        int res = 0;
        int left = 0;
        int right = l;
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if (canCut(mid, q)) { // 자를수 있으면
                res = Math.max(res, mid);
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return res;
    }

    private static boolean canCut(int minLen, int q) {
        int count = 0;
        int last = 0; 

        for (int i = 0; i < m; i++) {
            if (s[i] - last >= minLen) {
                count++;
                last = s[i];
            }
            
            if (count == q && (l - last) >= minLen) {
                return true;
            }
        }
        return false;
    }
}

// 10 10 15 20 5 10