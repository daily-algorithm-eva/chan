import java.io.*;
import java.util.*;

class Main {
    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> hm = new HashMap<>();
            for(int i = 0;i<n;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String type = st.nextToken();
                if(hm.containsKey(type)) {
                    hm.put(type, hm.get(type) + 1);
                }
                else {
                    hm.put(type, 1);
                }
            }
            
            int res = 1;
            for(int i : hm.values()) {
                res *= (i+1);
            }
            sb.append(res-1 + "\n");
        }

        System.out.print(sb);
    }
}