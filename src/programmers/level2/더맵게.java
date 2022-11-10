package programmers.level2;

import java.util.PriorityQueue;

public class 더맵게 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,2,3,9,10,12}, 7));
    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        while (true){
            int lower = pq.poll();
            if(lower < K){
                answer++;
                if(!pq.isEmpty()) lower *= (2 * pq.poll());
                else return -1;
            }else{
                return answer;
            }
            pq.add(lower);
        }
    }
}
