package programmers.level2;

import java.util.HashMap;

public class 할인행사 {
    static HashMap<String ,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] num = {3,2,2,2,1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(solution(want,num,discount));

    }

    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i < discount.length-9; i++) {
            int count = 10;
            for (int j = i; j < i+10; j++) {
                if(map.containsKey(discount[j])){
                    if(map.get(discount[j]) > 0) count--;
                    map.put(discount[j], map.get(discount[j])-1);
                }
            }
            if (count == 0) answer++;

            for (int j = i; j < i+10; j++) {
                if(map.containsKey(discount[j])){
                    map.put(discount[j], map.get(discount[j])+1);
                }
            }
        }
        return answer;
    }
}
