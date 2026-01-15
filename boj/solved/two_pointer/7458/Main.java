import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[][] arr;
    static int[] ab;
    static int[] cd;
    static long count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][4];
        for(int i = 0;i<n;i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j = 0 ;j<4;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ab = new int[n*n];
        cd = new int[n*n];
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                ab[i*n + j] = arr[i][0] + arr[j][1];
                cd[i*n + j] = arr[i][2] + arr[j][3];
            }
        }

        Arrays.sort(ab);
        Arrays.sort(cd);
        
        int abIdx = 0;
        int cdIdx = n*n-1;

        while(true) { // O(16000000 + 16000000)
            if(abIdx > n*n-1 || cdIdx < 0) break;
            
            int tmp = ab[abIdx] + cd[cdIdx];
            if(tmp > 0) {
                cdIdx -=1;
            }
            else if(tmp < 0) {
                abIdx +=1;
            }
            else { // tmp == 0
                int abTmp = ab[abIdx];
                int cdTmp = cd[cdIdx];

                long abCount = 0;
                while (abIdx < n*n && ab[abIdx] == abTmp) {
                    abCount++;
                    abIdx++;
                }

                long cdCount = 0;
                while (cdIdx >= 0 && cd[cdIdx] == cdTmp) {
                    cdCount++;
                    cdIdx--;
                }

                count += abCount * cdCount;
            }
        }

        System.out.println(count);
    }
}
