package programmers.level2;

import java.util.*;

public class 기능개발 {

    public static void main(String[] args) {
        int[] a = {93,30,55};
        int[] b = {1, 30, 5};
        System.out.println(solution(a,b));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            q.add(progresses[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        while(!q.isEmpty()){
            int count = 0;
            int mul = (int)Math.ceil((100 - q.peek()) / (double) speeds[index++]);
            q.poll();
            while(!q.isEmpty()){
                if(q.peek() + speeds[index] * mul >= 100){
                    index++;
                    q.poll();
                    count++;
                }else{
                    break;
                }
            }
            list.add(++count);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

