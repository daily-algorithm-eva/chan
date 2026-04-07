import java.io.*;
import java.util.*;

class Main {
    static int a, b;
    static List<int[]> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        for(int i = a; i<=b;i+=a) {
            if (b % i == 0) {
                nums.add(new int[]{i, (int)i/a, (int)b/i});
            }
        }
        
        int min = 200000001;
        int resA = a;
        int resB = b;
        for(int i = 0;i<nums.size();i++) {
            for(int j = i+1;j<nums.size();j++) {
                if(min > nums.get(i)[0] + nums.get(j)[0] && gcd(nums.get(i)[1], nums.get(j)[1]) == 1 && gcd(nums.get(i)[2], nums.get(j)[2]) == 1) {
                    min = nums.get(i)[0] + nums.get(j)[0];
                    resA = nums.get(i)[0];
                    resB = nums.get(j)[0];
                }
            }
        }

        System.out.println(resA + " " + resB);
    }

    public static int gcd(int a, int b) {
    if(b == 0) {
        return a;
    }
    return gcd(b, a % b);
}
}


// 6 12 18 24 30 36
// 1 2  3. 4  5. 6
// 3015 10 x. 6. 5

// a의 배수 b의 약수 중 가중치가 서로소인 수
