import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int count = 0;
            for (int i = 1; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((i * i + j * j + m) % (i * j) == 0) {
                        count += 1;
                    }
                }
            }
            sb.append(count + "\n");
        }
        System.out.print(sb);
    }
}