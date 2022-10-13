package programmers.level2;


import java.util.HashSet;

public class 영어끝말잇기 {
    public static void main(String[] args) {
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println(solution(2, words)[0] + " " + solution(2, words)[1]);
    }

    public static int[] solution(int n, String[] words) {
        int a = 0;
        int b = 0;

        HashSet<String> set = new HashSet<>();
        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if(set.contains(words[i]) || words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                a = i % n + 1;
                b = i / n + 1;
                break;
            }else{
                set.add(words[i]);
            }
        }
        return new int[] {a,b};
    }
}
