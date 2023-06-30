import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i=1; i<= s.length()/2; i++){
            int count = 1;
            StringBuilder sb = new StringBuilder();
            String str = "";
            int index = 0;
            for(int j=0; j<s.length() - i; j+=i){
                str = s.substring(j,j+i);
                int lastIndex = j+(i*2) > s.length() ? s.length() : j+(i*2);
                if(str.equals(s.substring(j+i, lastIndex))){
                    count++;
                }else{
                    if(count > 1) sb.append(count).append(str);
                    else sb.append(str);
                    count = 1;
                }
                index = j;
            }
            String substring = s.substring(index+i);
            if(count > 1) sb.append(count).append(substring);
            else sb.append(substring);
            answer = Math.min(answer, sb.length());
        }
        return answer;
    }
}