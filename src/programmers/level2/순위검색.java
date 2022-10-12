package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class 순위검색 {
    static HashMap<String , List<Integer>> map = new HashMap<>();


    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        System.out.println(solution(info, query));
    }


    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (int i = 0; i < info.length; i++) {
            dfs("", 0, info[i].split(" "));
        }

        for (String key: map.keySet()) {
            Collections.sort(map.get(key));
        }

        for(int i=0; i < query.length; i++) {
            String[] q = query[i].split(" and | ");
            answer[i] = map.containsKey(q[0] + q[1] + q[2] + q[3]) ? binarySearch(q[0] + q[1] + q[2] + q[3], Integer.parseInt(q[4])) : 0;

        }
        return answer;
    }

    static int binarySearch(String key, int score){
        List<Integer> list = map.get(key);
        int start = 0;
        int end = list.size()-1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(list.get(mid) < score){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return list.size() -start;
    }
    static void dfs(String info, int count, String[] words){
        if(count == 4){
            if(!map.containsKey(info)){
                List<Integer> list = new ArrayList<>();
                map.put(info, list);
            }
            map.get(info).add(Integer.parseInt(words[4]));
            return;
        }
        dfs(info + words[count], count+1, words);
        dfs(info + "-", count+1, words);
    }
}
