import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] arr;
    static List<Integer> res = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[n];
        res.add(arr[0]);
        for(int i = 0;i<n;i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (res.get(res.size()-1) > tmp) {
                res.add(tmp);
            }
            else {
                res.set(binarySearch(tmp), tmp);
            }
        }
        
        System.out.println(res.size());
    }

    public static int binarySearch(int num) {
        int l = 0;
        int r = res.size()-1;
        int pointIdx = res.size()-1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if (res.get(mid) > num) {
                l = mid +1;
            }
            else {
                r = mid - 1;
                pointIdx = Math.min(pointIdx, mid);
            }
        }
        return pointIdx;
    }
}