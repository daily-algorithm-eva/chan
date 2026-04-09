import java.io.*;
import java.util.*;

class Main {
    static int t;
    static int k,m,p;
    static List<Integer>[] nodes;
    static int[] sequences;
    static int[] strahler;
    static boolean[] visited; // 들어오는 강의 최댓값이 2개이상 들어왔는가

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());
        while(t--> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            p = Integer.parseInt(st.nextToken());
            nodes = new List[m+1];
            for(int i = 0;i<=m;i++) {
                nodes[i] = new ArrayList<>();
            }
            sequences = new int[m+1];
            strahler = new int[m+1];
            visited = new boolean[m+1];
            for(int i = 0;i<p;i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                nodes[a].add(b);
                sequences[b] += 1;
            }

            Queue<Integer> q = new LinkedList<>();
            // 루트 노드 큐에 넣기
            for(int i = 1;i<=m;i++) {
                if(sequences[i] == 0) {
                    strahler[i] = 1;
                    q.add(i);
                }
            }
            
            while(!q.isEmpty()) {
                int node = q.poll();
                for(int tmp : nodes[node]) {
                    sequences[tmp] -=1;
                    if(strahler[tmp] == strahler[node]) {
                        visited[tmp] = true;
                    }
                    if (strahler[tmp] < strahler[node]) {
                        strahler[tmp] = strahler[node];
                        visited[tmp] = false;
                    }
                    
                    if (sequences[tmp] == 0) {
                        q.add(tmp);
                        if (visited[tmp]) {
                            strahler[tmp] +=1;
                        }
                    }
                }
            }
            
            sb.append(k + " " + strahler[m] + "\n");
        }

        System.out.println(sb);
    }
}