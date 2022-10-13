package programmers.level2;

import java.util.ArrayDeque;

public class 짝지어제거하기 {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }

    public static int solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.size() == 0) stack.push(s.charAt(i));
            else if(stack.peekFirst() == s.charAt(i)) stack.pop();
            else stack.push(s.charAt(i));
        }
        return stack.size() > 0 ? 0 : 1;
    }
}
