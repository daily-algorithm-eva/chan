import java.io.*;
import java.util.*;

class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> names = new HashMap<>();
        HashMap<Integer, String> numbers = new HashMap<>();

        for(int i = 1; i<= n;i++) {
            String tmp = br.readLine();
            names.put(tmp, i);
            numbers.put(i, tmp);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<m;i++) {
            String tmp = br.readLine();
            char first = tmp.toCharArray()[0];
            if(first >= 'A' && first <= 'z') {
                sb.append(names.get(tmp) + "\n");
            }
            else{
                sb.append(numbers.get(Integer.parseInt(tmp)) + "\n");
            }
        }

        System.out.print(sb);
    }
}