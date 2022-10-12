package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 숫자문자열과영단어 {

    static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
    }

    public static int solution(String s) {
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(Character.isAlphabetic(s.charAt(i))){
                String newS = s.substring(count, i+1);
                if(map.containsKey(newS)){
                    sb.append(map.get(newS));
                    count = i+1;
                }
            }else{
                sb.append(s.charAt(i));
                count = i+1;
            }
        }
        return Integer.parseInt(sb.toString());
    }

}
