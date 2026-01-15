import java.io.*;
import java.util.*;

class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static HashSet<Integer> hs = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        visited = new boolean[n+1];
        for(int i = 1;i<=n;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 1;i<=n;i++) {
            visited = new boolean[n+1];
            visited[i] = true;
            if(dfs(i, i)) {
                for(int j = 0;j<n;j++) {
                    if(visited[i]) {
                        hs.add(i);
                    }
                }
            }
        }
        System.out.println(hs.size());
        List<Integer> res = new ArrayList<>(hs);
        res.sort(Comparator.naturalOrder());
        for(int tmp : res) {
            System.out.println(tmp);
        }
    }

    public static boolean dfs(int num, int end) {
        if(arr[num] == end) {
            return true;
        }
        if(visited[arr[num]]) {
            return false;
        }
        visited[arr[num]] = true;
        return dfs(arr[num], end);
    }
}