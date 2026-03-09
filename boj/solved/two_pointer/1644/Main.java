import java.io.*;
import java.util.*;

class Main {
    static int n;
    static List<Integer> arr;
    static boolean[] isPrime;
    static int[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();
        isPrime = new boolean[n + 1];

        getPrimes(n);
        for(int i = 2;i<=n;i++) {
            if(isPrime[i]) {
                arr.add(i);
            }
        }
        prefixSum = new int[arr.size()];
        
        int tmp = 0;
        for(int i = 0;i<arr.size();i++) {
            tmp += arr.get(i);
            prefixSum[i] = tmp;
        }

        int l = 0;
        int r = 0;
        int sum = 0;
        int count = 0;
        while(r < arr.size()) {
            int prefixR = prefixSum[r];
            int prefixL = (l == 0) ? 0 : prefixSum[l-1];
            sum = prefixR - prefixL;
            if(sum == n) {
                count +=1;
                r += 1;
            }
            if(sum < n) {
                r += 1;
            }
            if(sum > n) {
                l += 1;
            }
        }
        

        System.out.println(count);
    }

    public static void getPrimes(int max) {
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
