import java.io.*;
import java.util.*;

class Main {
    static int t;
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());
        while(t-- >0) {
            n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            for(int i = 0;i<n;i++) {
                arr[i] = br.readLine();
            }

            Arrays.sort(arr);
            boolean check = true;
            for(int i = 0;i<n;i++) {
                if(arr[i+1].startsWith(arr[i])) {
                    check = false;
                    break;
                }
            }

            if(check) {
                sb.append("YES\n");
            }
            else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}
