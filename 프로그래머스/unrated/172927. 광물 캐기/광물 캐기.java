import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int len = Math.min((picks[0] * 5 + picks[1] * 5 + picks[2] * 5), minerals.length);
        int chunk = (int)Math.ceil(len/5.0);
        String[][] group = new String[chunk][5];
        //picks와 minerals의 길이 중 짧은걸 기준으로 group을 나눔
        for(int i=0; i<chunk; i++){
            int start = i * 5;
            int length = Math.min(len - start, 5);
            String[] temp = new String[length];
            for(int j=0; j<length; j++){
                temp[j] = minerals[start + j];
            }
            group[i] = temp;
        }

        int[][] rank = new int[chunk][2];
        //각 미네랄별 소모값 연산
        for(int i=0; i<chunk; i++){
            rank[i][0] = i;
            rank[i][1] = getTotalTired(group[i]);
        }
        //피로도 적은순으로 정렬
        if(chunk > 1) Arrays.sort(rank, (e1, e2) -> e2[1] - e1[1]);

        //곡괭이와 미네랄 연산
        int index = 0;
        int mineralIndex = 0;
        while(index < 3 && mineralIndex < chunk){
            if(picks[index] > 0){
                picks[index]--;
                answer += getTired(index, group[rank[mineralIndex++][0]]);
            }else index++;
        }
        return answer;
    }
    
    static int getTotalTired(String[] m){
        int result = 0;
        for(String s : m){
            if(s.equals("stone")) result += 1;
            else if(s.equals("iron")) result += 5;
            else result += 25;
        }
        return result;
    }
    
    static int getTired(int index, String[] mineral){
        int result = 0;
        if(index == 0){
            result += mineral.length;
        }else if(index == 1){
            for(String m : mineral){
                if(m.equals("diamond")) result += 5;
                else result += 1;
            }
        }else{
            for(String m : mineral){
                if(m.equals("diamond")) result += 25;
                else if(m.equals("iron"))result += 5;
                else result += 1;
            }
        }
        return result;
    }
}