package programmers.level2;

import java.util.Arrays;
import java.util.Collections;

public class 가장큰수 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 30, 34, 5, 9}));
    }
    public static String solution(int[] numbers) {
        String answer = "";

        String[] arr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(arr, (e1, e2) -> (e2+e1).compareTo(e1+e2));

        for(int i=0;i<numbers.length;i++) answer+= arr[i];
        if(answer.charAt(0) == '0') return "0";
        return answer;
    }
}
