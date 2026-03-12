import java.io.*;
import java.util.*;

class Main {
    static int[][] arr = new int[3][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i = 0;i<3;i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j = 0;j<3;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int xCount = 0;
        int oCount = 0;
        for(int i = 0;i<3;i++) {
            for(int j = 0;j<3;j++) {
                if(arr[i][j] == 1){
                    xCount +=1;
                }
                if(arr[i][j] == 2) {
                    oCount +=1;
                }
            }
        }
        int player = xCount == oCount ? 1 : 2;
        int res = func(player);
        if(res == 0) {
            System.out.println("L");
        }
        if(res == 1) {
            System.out.println("D");
        }
        if(res == 2) {
            System.out.println("W");
        }
        
    }
    // 2 : 이김, 1 : 비김, 0 : 짐
    // 현재 플레이어가 얻을 수 있는 최선의 결과
    public static int func(int player) {
        if(isWin(3-player)) { // 상대방이 이미 이겼을 경우
            return 0;
        }

        int res = 2;
        boolean check = false;
        for(int i = 0 ;i<3;i++) {
            for(int j = 0;j<3;j++) {
                if(arr[i][j] == 0) {
                    check = true;
                    arr[i][j] = player;
                    res = Math.min(res, func(3- player));
                    arr[i][j] = 0;
                }
            }
        }

        if(!check) {
            return 1;
        }
        return 2 - res;
    }


    public static boolean isWin(int p) {
        for (int i = 0; i < 3; i++) {
            if (arr[i][0] == p && arr[i][1] == p && arr[i][2] == p) 
                return true;
            if (arr[0][i] == p && arr[1][i] == p && arr[2][i] == p) 
                return true;
        }
        if (arr[0][0] == p && arr[1][1] == p && arr[2][2] == p) 
            return true;
        if (arr[0][2] == p && arr[1][1] == p && arr[2][0] == p) 
            return true;
        return false;
    }
}
