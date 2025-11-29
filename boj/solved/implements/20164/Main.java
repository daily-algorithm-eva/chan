import java.io.*;
import java.util.*;

class Main {
    static String n;
    static int max = 0;
    static int min = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine();

        func(n, 0);
        System.out.println(min + " " + max);
    }
    
    // 홀수 개수 찾기
    public static int checkOdd(String num) {
        int sum = 0;
        for(int i =0;i<num.length();i++) {
            int tmp = Integer.parseInt(num.substring(i, i+1));
            if(tmp %2 == 1) {
                sum +=1;
            }
        }
        return sum;
    }

    public static int func(String num, int lastSum) {
        lastSum += checkOdd(num);
        int len = num.length();
        if(len >= 3) { // 나누기
            for(int i =1;i<=len-2;i++) {
                for(int j =1;j<=len-2;j++) {
                    int k = len-i-j;
                    if(k<=0) continue;
                    int num1 = Integer.parseInt(num.substring(0, i));
                    int num2 = Integer.parseInt(num.substring(i, i+j));
                    int num3 = Integer.parseInt(num.substring(i+j, i+j+k));
                    func(String.valueOf(num1+num2+num3), lastSum);
                }
            }
        }
        else if(len == 2) { // 합치기
            int num1 = Integer.parseInt(num.substring(0, 1));
            int num2 = Integer.parseInt(num.substring(1, 2));
            func(String.valueOf(num1+num2), lastSum);
        }
        else{ // 길이가 1일때 최소 최대 판별
            max = Math.max(max, lastSum);
            min = Math.min(min, lastSum);
            return lastSum;
        }
        return 0;
    }
}