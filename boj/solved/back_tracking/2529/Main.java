import java.io.*;
import java.util.*;

class Main {
    static int k;
    static String[] arr;
    static boolean[] visited;
    static long max = 0;
    static String maxRes;
    static long min = 10000000000L;
    static String minRes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        arr = br.readLine().split(" ");
        visited = new boolean[10];
        for(int i = 0;i<10;i++) {
            visited[i] = true;
            dfs(0, i, String.valueOf(i));
            visited[i] = false;
        }

        System.out.println(maxRes);
        System.out.println(minRes);
    }

    public static void dfs(int idx, int lastNum, String value) {
        if(idx == k) {
            long valueNum = Long.parseLong(value);
            if(max < valueNum) {
                max = valueNum;
                maxRes = value;
            }
            if(min > valueNum) {
                min = valueNum;
                minRes = value;
            }
            return;
        }

        if(arr[idx].equals("<")) {
            for(int i = lastNum+1;i<10;i++) {
                if(visited[i]) {
                    continue;
                }
                visited[i] = true;
                dfs(idx+1, i, value+i);
                visited[i] = false;
            }
        }
        else {
            for(int i = lastNum-1;i>=0;i--) {
                if(visited[i]) {
                    continue;
                }
                visited[i] = true;
                dfs(idx+1, i, value+i);
                visited[i] = false;
            }
        }
    }
}