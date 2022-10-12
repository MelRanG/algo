package programmers.level3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
    static PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);

    public static void main(String[] args) {
        int[][] jobs = {{0,3}, {1,9}, {2,6}};
        System.out.println(solution(jobs));
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (e1, e2) -> e1[0] - e2[0]);
        int jobIndex = 0;
        int end = 0;
        int count = 0;
        while (count < jobs.length){

            while (jobIndex < jobs.length && jobs[0][0] <= end){
                pq.add(jobs[jobIndex++]);
            }
            if(pq.isEmpty()){
                end = jobs[jobIndex][0];
            }else{
                int[] temp = pq.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }

        }
        return (int) Math.floor(answer / jobs.length);
    }

}
