package programmers.level2;

import java.util.ArrayList;
import java.util.List;


public class 뉴스클러스터링 {

    public static void main(String[] args) {

    }

    public int solution(String str1, String str2) {
        int answer = 0;
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for(int i = 0; i < str1.length()-1; i++){
            String s = str1.substring(i, i+2);
            if(s.matches("^[a-z]+$")) list1.add(s);
        }

        for(int i = 0; i < str2.length()-1; i++){
            String s = str2.substring(i, i+2);
            if(s.matches("^[a-z]+$")) list2.add(s);
        }
        if(list1.isEmpty() && list2.isEmpty()) return 65536;
        int sum = list1.size() + list2.size();
        int same = 0;
        for(String s : list1){
            if(list2.contains(s)){
                list2.remove(s);
                same++;
            }
        }
        double j = (double) same / (double)(sum - same);
        return (int)(j * 65536);
    }
}
