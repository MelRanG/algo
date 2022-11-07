package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 압축 {
    public static void main(String[] args) {
        System.out.println(solution("KAKAO"));
    }

    public static int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(Character.toString((char)('A' + i)));
        }
        int index = 0;
        int lastIndex = 0;
        String s = "";
        while (index < msg.length()){
            s += msg.charAt(index);
            if(list.indexOf(s) >= 0){
                index++;
                lastIndex = list.indexOf(s) + 1;
            }else{
                list.add(s);
                s = "";
                answer.add(lastIndex);
            }
        }
        answer.add(lastIndex);
        return Arrays.stream(answer.toArray()).mapToInt(i-> (int) i).toArray();
    }
}
