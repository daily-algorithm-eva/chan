import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] arr;
    static int[] tmp;
    static int[] answer;
    static boolean[] visited;
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        tmp = new int[n*2];
        Arrays.fill(tmp, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        func(0);
        StringBuilder sb = new StringBuilder();
        if(!check) {
            sb.append("-1");
        }
        else {
            for(int i = 0;i<n*2;i++) {
                sb.append(answer[i] + " ");
            }
        }

        System.out.println(sb);
    }

    public static void func(int idx) {
        if(check) return;
        if(idx == n*2) {
            check = true;
            answer = tmp.clone();
            return;
        }
        if(tmp[idx] != -1) {
            func(idx+1);
            return;
        }

        for(int i = 0;i<n;i++) {
            if(visited[i]) continue;
            if(idx + arr[i] + 1 >= n*2) break;
            if(tmp[idx + arr[i] + 1] != -1) continue;
            visited[i] = true;
            tmp[idx] = arr[i];
            tmp[idx + arr[i] + 1] = arr[i];
            func(idx +1);
            visited[i] = false;
            tmp[idx] = -1;
            tmp[idx + arr[i] + 1] = -1;
        }
    }
}