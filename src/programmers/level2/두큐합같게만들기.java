package programmers.level2;

import java.util.ArrayDeque;

public class 두큐합같게만들기 {

    public static void main(String[] args) {
        int[] q1 = {1,1,1,1,1};
        int[] q2 = {1,1,1,9,1};

        System.out.println(solution(q1, q2));
    }

    public static int solution(int[] queue1, int[] queue2) {
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();

        int answer = -1;
        long q1Sum = 0;
        long q2Sum = 0;

        for (int i = 0; i < queue1.length; i++) {
            q1Sum += queue1[i];
            q2Sum += queue2[i];

            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }
        int count = 0;
        if((q1Sum + q2Sum) % 2 != 0) return -1;

        for (int i = 0; i < queue1.length * 3; i++) {
            if(q1Sum == q2Sum) return count;
            else if(q1Sum < q2Sum){
                int v = q2.poll();
                q2Sum -= v;
                q1Sum += v;
                q1.add(v);
            }else{
                int v = q1.poll();
                q1Sum -= v;
                q2Sum += v;
                q2.add(v);
            }
            count++;
        }
        return answer;
    }
}
