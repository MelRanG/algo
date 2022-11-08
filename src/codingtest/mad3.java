package codingtest;

import java.util.ArrayDeque;
import java.util.HashMap;

/*
괄호에서 하나빠지기
 */
public class mad3 {
    static HashMap<Character, Character> map = new HashMap< >();

    public static void main(String[] args) {
        solution("{({})}");
    }

    public static int solution(String s){
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                char c = stack.pop();
                if(c != map.get(s.charAt(i))){
                    System.out.println(isBracket(s));
                }
            }else {
                stack.push(s.charAt(i));
            }
        }
        return 1;
    }

    public static boolean isBracket(String s){
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                char c = stack.pop();
                if(c != map.get(s.charAt(i))){
                    return false;
                }
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.size() == 0 ? true : false;
    }
}
