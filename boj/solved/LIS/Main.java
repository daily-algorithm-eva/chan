import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] arr;
    static List<Integer> memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        memo = new ArrayList<>();

        memo.add(arr[0]);
        for(int i = 1;i<n;i++) {
            if(arr[i] > memo.get(memo.size()-1)) {
                memo.add(arr[i]);
            }
            else {
                int idx = binarySearch(arr[i]);
                memo.set(idx, arr[i]);
            }
        }

        System.out.println(memo.size());
    }

    public static int binarySearch(int value) { // 같거나 큰것중에 갈아끼기
        int l = 0;
        int r = memo.size()-1;

        int point = 0;
        while(l <= r) {
            int mid = (l+r) / 2;
            if(memo.get(mid) >= value) {
                point = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return point;
    }
}
