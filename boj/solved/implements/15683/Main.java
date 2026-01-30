import java.io.*;
import java.util.*;

class Main {
    static int n,m;
    static int res = 65;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for(int i = 0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<m;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0, arr);
        System.out.println(res);
    }

    public static int checkFill(int[][] arr) {
        int count = 0;
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(arr[i][j] == 0) {
                    count +=1;
                }
            }
        }
        return count;
    }
    public static void dfs(int x, int y, int[][] arr) {
        if(x==n) {
            res = Math.min(res, checkFill(arr));
            return;
        }

        int num = arr[x][y];
        if(num == 1) {
            int[][] tmpArr = upSide(x, y, -1, arr);
            dfs(x + (int)((y+1) / m), (y+1) % m, tmpArr);
            tmpArr = downSide(x, y, -1, arr);
            dfs(x + (int)((y+1) / m), (y+1) % m, tmpArr);
            tmpArr = leftSide(x, y, -1, arr);
            dfs(x + (int)((y+1) / m), (y+1) % m, tmpArr);
            tmpArr = rightSide(x, y, -1, arr);
            dfs(x + (int)((y+1) / m), (y+1) % m, tmpArr);
            return;
        }
        if(num == 2) {
            int[][] tmpArr = upSide(x, y, -1, arr);
            tmpArr = downSide(x, y, -1, tmpArr);
            dfs(x + (int)((y+1) / m), (y+1) % m, tmpArr);
            tmpArr = leftSide(x, y, -1, arr);
            tmpArr = rightSide(x, y, -1, tmpArr);
            dfs(x + (int)((y+1) / m), (y+1) % m, tmpArr);
            return;
        }
        if(num == 3) {
            int[][] tmpArr = upSide(x, y, -1, arr);
            tmpArr = rightSide(x, y, -1, tmpArr);
            dfs(x + (int)((y+1) / m), (y+1) % m, tmpArr);
            tmpArr = upSide(x, y, -1, arr);
            tmpArr = leftSide(x, y, -1, tmpArr);
            dfs(x + (int)((y+1) / m), (y+1) % m, tmpArr);
            tmpArr = rightSide(x, y, -1, arr);
            tmpArr = downSide(x, y, -1, tmpArr);
            dfs(x + (int)((y+1) / m), (y+1) % m, tmpArr);
            tmpArr = leftSide(x, y, -1, arr);
            tmpArr = downSide(x, y, -1, tmpArr);
            dfs(x + (int)((y+1) / m), (y+1) % m, tmpArr);
            return;
        }
        if(num == 4) {
            int[][] tmpArr = upSide(x, y, -1, arr);
            tmpArr = rightSide(x, y, -1, tmpArr);
            tmpArr = leftSide(x, y, -1, tmpArr);
            dfs(x + (int)((y+1) / m), (y+1) % m, tmpArr);
            tmpArr = downSide(x, y, -1, arr);
            tmpArr = leftSide(x, y, -1, tmpArr);
            tmpArr = rightSide(x, y, -1, tmpArr);
            dfs(x + (int)((y+1) / m), (y+1) % m, tmpArr);
            tmpArr = rightSide(x, y, -1, arr);
            tmpArr = downSide(x, y, -1, tmpArr);
            tmpArr = upSide(x, y, -1, tmpArr);
            dfs(x + (int)((y+1) / m), (y+1) % m, tmpArr);
            tmpArr = leftSide(x, y, -1, arr);
            tmpArr = downSide(x, y, -1, tmpArr);
            tmpArr = upSide(x, y, -1, tmpArr);
            dfs(x + (int)((y+1) / m), (y+1) % m, tmpArr);
            return;
        }
        if(num == 5) {
            int[][] tmpArr = upSide(x, y, -1, arr);
            tmpArr = rightSide(x, y, -1, tmpArr);
            tmpArr = leftSide(x, y, -1, tmpArr);
            tmpArr = downSide(x, y, -1, tmpArr);
            dfs(x + (int)((y+1) / m), (y+1) % m, tmpArr);
            return;
        }
        
        dfs(x + (int)((y+1) / m), (y+1) % m, arr);
    }

    public static int[][] upSide(int x, int y, int check, int[][] arr) {
        int[][] startArr = new int[n][m];
        for(int i = 0;i<n;i++) {
            startArr[i] = arr[i].clone();
        }
        for(int i = x-1;i>=0; i--) {
            if(startArr[i][y] == 6){
                break;
            }
            if(startArr[i][y] != 0) {
                continue;
            }
            startArr[i][y] = check;
        }
        return startArr;
    }
    public static int[][] leftSide(int x, int y, int check, int[][] arr) {
        int[][] startArr = new int[n][m];
        for(int i = 0;i<n;i++) {
            startArr[i] = arr[i].clone();
        }
        for(int i = y-1;i>=0; i--) {
            if(startArr[x][i] == 6){
                break;
            }
            if(startArr[x][i] != 0) {
                continue;
            }
            startArr[x][i] = check;
        }
        return startArr;
    }
    public static int[][] rightSide(int x, int y, int check, int[][] arr) {
        int[][] startArr = new int[n][m];
        for(int i = 0;i<n;i++) {
            startArr[i] = arr[i].clone();
        }
        for(int i = y+1;i<m; i++) {
            if(startArr[x][i] == 6){
                break;
            }
            if(startArr[x][i] != 0) {
                continue;
            }
            startArr[x][i] = check;
        }
        return startArr;
    }
    public static int[][] downSide(int x, int y, int check, int[][] arr) {
        int[][] startArr = new int[n][m];
        for(int i = 0;i<n;i++) {
            startArr[i] = arr[i].clone();
        }
        for(int i = x+1;i<n; i++) {
            if(startArr[i][y] == 6){
                break;
            }
            if(startArr[i][y] != 0) {
                continue;
            }
            startArr[i][y] = check;
        }
        return startArr;
    }
}