import java.io.*;
import java.util.*;

class Main {
    static int t;
    static int n;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i + 1;
            }

            dfs(1, String.valueOf(arr[0]));
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void dfs(int idx, String eq) {
        if(idx == n) {
            if(checkZero(eq)) {
                sb.append(eq + "\n");
            }
            return;
        }

        dfs(idx + 1, eq + " " + arr[idx]);
        dfs(idx + 1, eq + "+" + arr[idx]);
        dfs(idx + 1, eq + "-" + arr[idx]);
    }

    public static boolean checkZero(String eq) {
        char[] tmp = eq.replaceAll(" ", "").toCharArray();
        
        int sum = 0;
        char operator = '+';
        for(int i = 0;i<tmp.length;i++) {
            
            if(tmp[i] != '+' && tmp[i] != '-') {
                String value = "";
                while(i < tmp.length && tmp[i] != '+' && tmp[i] != '-') {
                    value += String.valueOf(tmp[i]);
                    i+=1;
                }
                i-=1;
                if(operator == '+') {
                    sum += Integer.parseInt(value);
                }
                else {
                    sum -= Integer.parseInt(value);
                }
            }
            operator = tmp[i];
        }

        if(sum == 0) {
            return true;
        }
        return false;
    }
}