import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    static int[] arr;
    static Deque<Integer> dq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        dq = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<m;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1;i<=n;i++) {
            dq.add(i);
        }
        int idx = 0;
        int res = 0;
        while(idx < m) {
            int size = dq.size();
            int checkIdx = 0;
            Object[] tmpArr = dq.toArray();

            for(int i = 0;i<size;i++) {
                if((int)tmpArr[i] == arr[idx]) {
                    checkIdx = i;
                    break;
                }
            }
            if(checkIdx > size/2) { // 뒤에서 뺌
                int count = size - checkIdx;
                while(count-- > 0) {
                    dq.addFirst(dq.removeLast());
                    res +=1;
                }
                dq.removeFirst();
                idx +=1;
            }
            else { // 앞에서 뺌
                int count = checkIdx;
                while(count-- > 0) {
                    dq.addLast(dq.removeFirst());
                    res +=1;
                }
                dq.removeFirst();
                idx +=1;
            }
        }

        System.out.println(res);
    }
}