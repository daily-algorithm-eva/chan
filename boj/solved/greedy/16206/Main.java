import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        List<Integer> arr1 = new ArrayList<>(); // 10으로 나누어떨어지는 값
        List<Integer> arr2 = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n;i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp % 10 == 0) {
                arr1.add(tmp);
            }
            else {
                arr2.add(tmp);
            }
        }
        arr1.sort(null);

        int count = 0;
        for(int i = 0;i<arr1.size();i++) { // 10일때는 그냥 계속 추가
            int divedNum = arr1.get(i) / 10 - 1;
            if(divedNum > m) {
                count += m;
                m = 0;
            }
            else {
                m -= divedNum;
                count += divedNum + 1;
            }
        }

        for(int i = 0; i< arr2.size();i++) {
            if(m == 0) {
                break;
            }
            int divedNum = (int)(arr2.get(i) / 10);
            if(divedNum > m) {
                count += m;
                m = 0;
            }
            else {
                m -= divedNum;
                count += divedNum;
            }
        }

        System.out.println(count);
    }
}
// 10으로 나누어 지는 것 우선