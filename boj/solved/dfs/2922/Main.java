import java.io.*;
import java.util.*;

class Main {
    static HashSet<Character> vowel = new HashSet<>();
    static char[] funWord;
    static long res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        funWord = br.readLine().toCharArray();
        vowel.add('A');
        vowel.add('E');
        vowel.add('I');
        vowel.add('O');
        vowel.add('U');
        boolean isL = false;
        for(int i = 0;i<funWord.length;i++) {
            if(funWord[i] == 'L') {
                isL = true;
                break;
            }
        }
        dfs(0, 1, isL, 0, 0);

        System.out.println(res);
    }

    public static void dfs(int idx, long sum, boolean isL, int vowleSeq, int consonantsSeq) {
        if(vowleSeq == 3 || consonantsSeq == 3) {
            return;
        } 
        if(idx == funWord.length) { // 끝
            if(isL) {
                res += sum;
            }
            return;
        }
        if(funWord[idx] == '_') {
            // 모음이 들어갈 경우
            dfs(idx + 1, sum * 5, isL, vowleSeq + 1, 0);
            // 자음이 들어갈 경우
            // L이 들어가는 경우
            dfs(idx + 1, sum, true, 0, consonantsSeq + 1);
            dfs(idx + 1, sum * 20, isL, 0, consonantsSeq + 1);
        }
        else {
            boolean isVowel = vowel.contains(funWord[idx]);
            if(isVowel) {
                dfs(idx + 1, sum, isL, vowleSeq + 1, 0);
                return;
            }
            dfs(idx + 1, sum, isL, 0, consonantsSeq + 1);
        }
    }
}