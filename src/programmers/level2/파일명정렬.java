package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 파일명정렬 {
    public static void main(String[] args) {
        System.out.println(solution(new String[] {"a000", "b000"}));
    }

    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];

        List<String[]> list = new ArrayList<>();
        for(String file : files){
            String[] splitStr = new String[3];
            int i = 0;
            int j = 0;
            while(!Character.isDigit(file.charAt(i))) i++;
            splitStr[0] = file.substring(i);
            j = i;
            while(i < file.length() && Character.isDigit(file.charAt(i))) i++;
            splitStr[1] = file.substring(j,i);
            splitStr[2] = file.substring(i, file.length());
            list.add(splitStr);
        }

        Collections.sort(list, (e1, e2) -> (e1[0].toLowerCase().compareTo(e2[0].toLowerCase()) == 0 ? Integer.parseInt(e1[1]) - Integer.parseInt(e2[1])
                : e1[0].toLowerCase().compareTo(e2[0].toLowerCase())));
        for(int i=0; i < list.size(); i++){
            String[] arr = list.get(i);
            answer[i] = arr[0] + arr[1] + arr[2];
        }
        return answer;
    }
}
