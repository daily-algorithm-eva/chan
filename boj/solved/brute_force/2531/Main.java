import java.io.*;
import java.util.*;

class Main {
    static int n, d, k, c;
    static int[] cycle;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        cycle = new int[n];
        for(int i = 0;i<n;i++) {
            cycle[i] = Integer.parseInt(br.readLine());
        }

        int[] sushi = new int[d+1];
        int count = 0;
        int res = 0;
        for(int i = 0;i<k;i++) {
            if (sushi[cycle[i]] == 0) {
                count +=1;
            }
            sushi[cycle[i]] +=1;
            res = Math.max(res, count);
        }

        for(int i = 0;i<n;i++) { // 앞에 초밥(i)을 빼고 뒤의 초밥(i+k)을 추가   
            sushi[cycle[i]] -= 1;
            if (sushi[cycle[i]] == 0) {
                count -=1;
            }

            if (sushi[cycle[(i+k) % n]] == 0) {
                count +=1;
            }
            sushi[cycle[(i+k) % n]] += 1;

            if (sushi[c] == 0) {
                res = Math.max(res, count + 1);
            }
            else {
                res = Math.max(res, count);
            }
        }
        
        System.out.println(res);
    }
}