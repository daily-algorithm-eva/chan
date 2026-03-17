import java.io.*;
import java.util.*;

class Main {
    static int t;
    static int n;
    static int[] students;
    static boolean[] visited;
    static boolean[] finished;
    static int notTeamCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            n = Integer.parseInt(br.readLine());

            students = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1;i<=n;i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            notTeamCount = 0;

            for(int i = 1;i<=n;i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }

            sb.append((n-notTeamCount) + "\n");
        }

        System.out.print(sb);
    }

    public static void dfs(int num) {
        visited[num] = true;
        int next = students[num];
        
        if(!visited[next]) {
            dfs(next);
        }
        else {
            if (!finished[next]) {
                notTeamCount +=1;
                for(int i = next;i != num; i = students[i]) {
                    notTeamCount +=1;
                }
            }
        }
        finished[num] = true; // 판별 완료
    }
}