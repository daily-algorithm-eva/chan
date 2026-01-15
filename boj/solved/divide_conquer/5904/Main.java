import java.io.*;
import java.util.*;

class Main {
    static int n;
    static long sum;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        
        sum = 3;
        count = 4;
        while(n > sum) {
            sum  = sum * 2 + count;
            count +=1;
        }
        
        if(divideConquer(1, sum)){
            System.out.println("m");
        }
        else {
            System.out.println("o");
        }
    }

    public static boolean divideConquer(long start, long end) { // true : m, false : o
        count -=1;
        if(count == 3) {
            if(n == start) {
                return true;
            }
            return false;
        }

        if(n <= (start+end-count-1)/2) {  // 123
            return divideConquer(start, (start+end-count-1)/2);
        }
        else if(n > (start+end+count-1)/2) { //8910
            return divideConquer((start+end+count-1)/2 + 1, end);
        }
        else {
            if(n == (start+end-count-1)/2 + 1) { 
                return true;
            }
            return false;
        }
    }
}
// 3 4 3   5   3 4 3   6   3 4 3   5   3 4 3   7  3 4 3   5   3 4 3   6   3 4 3   5   3 4

