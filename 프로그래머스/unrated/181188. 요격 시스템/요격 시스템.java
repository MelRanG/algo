import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (e1, e2) -> e1[1] == e2[1] ? e1[0] - e2[0] : e1[1] - e2[1]);
        int result = 0;
        int end = Integer.MIN_VALUE;
        for(int i=0; i<targets.length; i++){
            if(end <= targets[i][0]){
                result++;
                end = targets[i][1];
            }
        }
        return result;
    }
}