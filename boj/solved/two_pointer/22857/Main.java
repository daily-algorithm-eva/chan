import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int near = 0; 
        int front = 0; 
        int oddCount = 0;
        int res = 0; 
        while (near < n) {
            if (arr[near] % 2 != 0) {
                oddCount++;
            }

            while (oddCount > k) {
                if (arr[front] % 2 != 0) {
                    oddCount--;
                }
                front++;
            }
            res = Math.max(res, near - front + 1 - oddCount);

            near++;
        }

        System.out.println(res);
    }
}