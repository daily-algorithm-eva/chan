import java.io.*;
import java.util.*;

class Main {
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] a = br.readLine().toCharArray();
        char[] b = br.readLine().toCharArray();
        char[] c = br.readLine().toCharArray();
        int aLen = a.length;
        int bLen = b.length;
        int cLen = c.length;
        int[][][] lcs = new int[aLen+1][bLen+1][cLen+1];
        int max = 0;
        for(int i = 1;i<=aLen;i++) {
            for(int j = 1;j<=bLen;j++) {
                for(int k = 1;k<=cLen;k++) {
                    if((a[i-1] == b[j-1]) && (b[j-1] == c[k-1])) {
                        lcs[i][j][k] = lcs[i-1][j-1][k-1] + 1;
                        continue;
                    }
                    lcs[i][j][k] = Math.max(lcs[i-1][j][k], Math.max(lcs[i][j-1][k], lcs[i][j][k-1]));
                }
            }
        }
        System.out.println(lcs[aLen][bLen][cLen]);
        
    }
}
