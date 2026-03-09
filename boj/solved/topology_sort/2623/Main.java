import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static List<Integer>[] arr;
    static int[] seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new List[n+1];
        seq = new int[n+1];

        for(int i = 0;i<=n;i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i = 0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] line = new int[num];
            
            for(int j = 0;j<num;j++) {
                line[j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 0;j<num-1;j++) { // 위상정렬 채우기
                for(int k = j+1;k<num;k++) {
                    arr[line[j]].add(line[k]);
                    seq[line[k]] +=1;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1;i<=n;i++) {
            if(seq[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(!q.isEmpty()) {
            int singer = q.poll();
            count +=1;
            sb.append(singer + "\n");

            for(int tmp : arr[singer]) {
                seq[tmp] -=1;
                if(seq[tmp] == 0) {
                    q.add(tmp);
                }
            }
        }

        if(count == n) {
            System.out.print(sb);
        }
        else {
            System.out.println(0);
        }
    }
}
// 위상 정렬