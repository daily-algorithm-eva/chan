import java.io.*;
import java.util.*;

class Main {
    static List<int[]> arr = new ArrayList<>();
    static int[][][] dp; // i번의 인덱스까지 j명의 백팀과 k명의 흑팀
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line;
        while((line = br.readLine()) != null && !line.isEmpty()) {
            StringTokenizer st = new StringTokenizer(line);
            int white = Integer.parseInt(st.nextToken());
            int black = Integer.parseInt(st.nextToken());
            arr.add(new int[]{white, black});
        }
        int playerNum = arr.size();
        dp = new int[playerNum+1][17][17];

        for(int i = 1;i<=playerNum;i++) {
            for(int j = 0;j<=15;j++) {
                for(int k = 0;k<=15;k++) {
                    // 백팀으로 뽑을 경우
                    dp[i][j+1][k] = Math.max(dp[i][j+1][k], dp[i-1][j][k] + arr.get(i-1)[0]);
                    // 흑팀으로 뽑을 경우
                    dp[i][j][k+1] = Math.max(dp[i][j][k+1], dp[i-1][j][k] + arr.get(i-1)[1]);
                    // 안 뽑을 경우
                    dp[i][j][k] = Math.max(dp[i][j][k], dp[i-1][j][k]);
                }
            }
        }

        System.out.println(dp[playerNum][15][15]);
    }
}
