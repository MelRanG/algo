package programmers.level2;

import java.util.*;

public class 기능개발 {

    public static void main(String[] args) {
        int[] a = {95, 90, 99, 99, 80, 99};
        int[] b = {1, 1, 1, 1, 1, 1};
        System.out.println(solution(a,b));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            queue.add((int) (Math.ceil((100.0 - progresses[i]) / speeds[i])));
        }

        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()){
            int day = queue.poll();
            int cnt = 1;

            while(!queue.isEmpty() && day >= queue.peek()){
                cnt++;
                queue.poll();
            }
            answer.add(cnt);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}

