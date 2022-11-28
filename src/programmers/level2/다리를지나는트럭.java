package programmers.level2;

import java.util.*;
class 다리를지나는트럭 {
    public static void main(String[] args) {
        System.out.println(solution(5, 5, new int[]{2, 2, 2, 2, 1, 1, 1, 1, 1}));
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        for(int i=0;i<bridge_length;i++)q.add(0);
        for(int i=0;i<truck_weights.length;i++)q2.add(truck_weights[i]);
        int totalWeight = 0;
        int result = 0;

        while(!q2.isEmpty()){
            if(totalWeight + q2.peek() <= weight){
                int value = q2.poll();
                totalWeight -= q.poll();
                q.add(value);
                totalWeight += value;
            }else{
                int value = q.poll();
                if(totalWeight - value + q2.peek() <= weight) {
                    int temp = q2.poll();
                    totalWeight += temp;
                    q.add(temp);
                }
                else q.add(0);
                totalWeight -= value;
            }
            result++;
        }
        return result + q.size();
    }
}
