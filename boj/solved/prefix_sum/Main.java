package boj.solved.prefix_sum;
import java.io.*;
import java.util.*;

class Main {
    static char[] s;
    static int q;
    static int[][] prefixSum; // i번째까지 j개의 문자열의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine().toCharArray();
        int slen = s.length;
        prefixSum = new int[slen+1][26];
        for(int i = 1;i<=slen;i++) {
            int idx = s[i-1] - 'a';
            for(int j = 0;j<26;j++) {
                prefixSum[i][j] = prefixSum[i-1][j];
            }
            prefixSum[i][idx] +=1;
        }

        q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<q;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char alpha = st.nextToken().charAt(0);
            int idx = alpha - 'a';
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append((prefixSum[r+1][idx] - prefixSum[l][idx]) + "\n");
        }   

        System.out.print(sb);
    }
}