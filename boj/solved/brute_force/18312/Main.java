import java.io.*;
import java.util.*;

class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    if (i % 10 == K || (int) i / 10 == K || j % 10 == K || (int) j / 10 == K || k % 10 == K
                            || (int) k / 10 == K) {
                        count += 1;
                    }
                }
            }
        }

        System.out.println(count);
    }
}