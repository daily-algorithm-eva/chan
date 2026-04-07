import java.io.*;
import java.util.*;

class Main {
    static long n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());

        long size = 1;
        while(size < n) {
            size *= 2;
        }
        
        int reverseCount = 0;
        while(size > 1) {
            long tmp = size/2;
            if(tmp < n) { // 오른쪽에 있을 경우
                size -= tmp;
                n -= tmp;
                reverseCount +=1;
            }
            else {
                size -= tmp;
            }
        }
        
        System.out.println(reverseCount % 2);
    }
}
// 01101001 10010110
// 12 16 -> 4 8 -> 4 4 -> 2 2 -> 1 1
// r r r
// 반으로 나눴을때 오른쪽에 있으면 reverse 왼쪽은 그대로