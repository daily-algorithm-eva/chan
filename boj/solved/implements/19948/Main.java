import java.io.*;
import java.util.*;

class Main {
    static char[] content;
    static int count;
    static int[] alpha;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        content = br.readLine().toCharArray();
        count = Integer.parseInt(br.readLine());
        alpha = new int[26];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0;i<26;i++) {
            alpha[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        boolean status = false;
        boolean success = true;
        char last = '.';
        for(int i = 0;i<content.length;i++) {
            if(last == content[i]) {
                continue;
            }
            if(content[i] == ' ') {
                count -=1;
                if(count < 0) {
                    success = false;
                    break;
                }
                status = false;
                last = content[i];
            }
            else if(!status) { // 첫글자 일때
                status = true;
                if(content[i] <= 'z' && content[i] >= 'a') {
                    sb.append((char)(content[i] - 'a' + 'A'));
                    alpha[content[i] - 'a'] -= 2;
                    if(alpha[content[i] - 'a'] < 0) {
                        success = false;
                        break;
                    }
                }
                else{
                    sb.append(content[i]);
                    alpha[content[i] - 'A'] -= 2;
                    if(alpha[content[i] - 'A'] < 0) {
                        success = false;
                        break;
                    }
                }   
            }
            else {
                if(content[i] <= 'z' && content[i] >= 'a') {
                    alpha[content[i] - 'a'] -= 1;
                    if(alpha[content[i] - 'a'] < 0) {
                        success = false;
                        break;
                    }
                }
                else{
                    alpha[content[i] - 'A'] -= 1;
                    if(alpha[content[i] - 'A'] < 0) {
                        success = false;
                        break;
                    }
                } 
            }
            last = content[i];
        }

        if(success) {
            System.out.println(sb);
        }
        else {
            System.out.println(-1);
        }
    }
}