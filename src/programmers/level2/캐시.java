package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class 캐시 {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new ArrayList<>();
        if (cacheSize == 0)
            return cities.length * 5;
        for (String city: cities) {
            if(list.contains(city.toLowerCase())){
                answer++;
                list.remove(city.toLowerCase());
                list.add(city.toLowerCase());
            }else{
                answer += 5;
                if(list.size() == cacheSize){
                    list.remove(0);
                    list.add(city.toLowerCase());
                }else{
                    list.add(city.toLowerCase());
                }
            }
        }
        return answer;
    }
}
