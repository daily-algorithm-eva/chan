import java.io.*;
import java.util.*;

class Main {
    static int k;
    static int weightSum;
    static int[] weights;
    static boolean[] possibleWeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        weights = new int[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            weightSum += weights[i];
        }

        possibleWeight = new boolean[weightSum + 1];
        recursion(0, 0);

        int res = 0;
        for (int i = 1; i <= weightSum; i++) {
            if (!possibleWeight[i]) {
                res += 1;
            }
        }
        System.out.println(res);
    }

    public static void recursion(int idx, int sum) {
        if (idx == k) {
            if(sum <= 0) return;
            possibleWeight[sum] = true;
            return;
        }

        recursion(idx + 1, sum + weights[idx]);
        recursion(idx + 1, sum - weights[idx]);
        recursion(idx + 1, sum);
    }
}