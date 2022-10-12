package programmers.level2;

public class 삼각달팽이 {


    public int[] solution(int n) {
        int[] answer = new int[n * (n + 1) / 2]; // 삼각형의 크기 ( 1 ~ n 까지 합)
        int[][] tri = new int[n][n];

        int x = -1;
        int y = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(i%3 == 0) x++;
                else if(i%3==1) y++;
                else if(i%3 == 2){
                    x--;
                    y--;
                }
                tri[x][y]=num++;
            }
        }
        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(tri[i][j] == 0) break;
                answer[index++] = tri[i][j];
            }
        }
        return answer;
    }
}
