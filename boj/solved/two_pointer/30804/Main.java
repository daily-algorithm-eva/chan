import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] fruits;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        fruits = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n;i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[10];
        int l = 0;
        int r = 0;
        int typeCount = 0;
        int res = 0;

        while (r < n) {
            if (count[fruits[r]] == 0) {
                typeCount++;
            }
            count[fruits[r]]++;
            r++;

            while (typeCount > 2) {
                count[fruits[l]]--;
                if (count[fruits[l]] == 0) {
                    typeCount--;
                }
                l++;
            }

            res = Math.max(res, r - l);
        }

        System.out.println(res);
    }
}