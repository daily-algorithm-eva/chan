import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static List<Integer>[] arr;
    static int[] sequence;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new List[n+1];
        for(int i = 0;i<=n;i++) {
            arr[i] = new ArrayList<>();
        }
        sequence = new int[n+1];
        for(int i = 0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            sequence[b] +=1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1;i<=n;i++) {
            if(sequence[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int num = q.poll();
            sb.append(num + " ");
            for(int tmp : arr[num]) {
                sequence[tmp] -=1;
                if(sequence[tmp] == 0) {
                    q.add(tmp);
                }
            }
        }

        System.out.println(sb);
    }
}
// 위상정렬