package programmers.level2;

import java.util.HashMap;

public class 모음사전 {

    static HashMap<Integer, String> map = new HashMap<>();
    static int result = 0;

    public static void main(String[] args) {
        System.out.println(solution("EIO"));
    }

    public static int solution(String word) {
        int answer = 0;

        dfs(word, "", 0);
        return result;
    }

    static boolean dfs(String word, String val, int n){
        if(word.equals(val)) return true;
        if(n == 5) return false;

        for (int i = 0; i < 5; i++) {
            result++;
            if(dfs(word, val + "AEIOU".charAt(i), n+1)) return true;
        }
        return false;
    }

}
