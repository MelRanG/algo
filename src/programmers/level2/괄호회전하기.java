package programmers.level2;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class 괄호회전하기 {
    public static void main(String[] args) {
        System.out.println(solution("{{"));
    }
    public static int solution(String s) {
        int answer = 0;
        Map<Character, Character> map = new HashMap<>();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> q = new ArrayDeque<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        for (int i = 0; i < s.length(); i++) {
            q.offer(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            boolean visited = true;
            for (int j = 0; j < s.length(); j++) {
                char c = q.poll();
                if(map.containsKey(c)){
                    if(stack.size() == 0 || map.get(c) != stack.pop()){
                        visited = false;
                    }
                }else{
                    stack.push(c);
                }
                q.offer(c);
            }
            if(visited && stack.size() == 0) answer++;
            stack.clear();
            q.offer(q.poll());
        }
        return answer;
    }
}
