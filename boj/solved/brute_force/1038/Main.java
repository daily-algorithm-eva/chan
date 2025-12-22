import java.io.*;
import java.util.*;

class Main {
    static int n;
    static List<Long> dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new ArrayList<>();
        
        for(int i = 0;i<10;i++) {
            recursion(i, i);
        }
        dp.sort(Comparator.naturalOrder());

        if(n >= dp.size()) {
            System.out.println(-1);
        }
        else{
            System.out.println(dp.get(n));
        }
    }

    public static void recursion(long num, long lastNum) {
        dp.add(num);
        
        for(int i = 0;i<lastNum;i++) {
            recursion(num*10+i, i);
        }
    }
}