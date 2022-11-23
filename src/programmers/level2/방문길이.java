package programmers.level2;

import java.util.ArrayDeque;

public class 방문길이 {
        static int[] dy = {1,-1,0,0};
        static int[] dx = {0,0,1,-1};
        static boolean[][][] visited = new boolean[11][11][4];

    public static void main(String[] args) {
        System.out.println(solution("RRRRR"));
    }
        public static int solution(String dirs) {
            int answer = 0;
            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.add(new int[]{5,5});
            int y = 5;
            int x = 5;
            int ny,nx;
            for(int i=0; i < dirs.length(); i++){
                int dir = 0;
                if(dirs.charAt(i) == 'U'){
                    ny = dy[0] +y;
                    dir = 0;
                    nx = x;
                }else if(dirs.charAt(i) == 'L'){
                    nx = dx[3] + x;
                    dir = 1;
                    ny = y;
                }else if(dirs.charAt(i) == 'D'){
                    ny = dy[1] + y;
                    dir = 2;
                    nx = x;
                }else{
                    nx = dx[2] + x;
                    dir = 3;
                    ny = y;
                }
                if(ny < 0 || ny > 10 || nx < 0 || nx > 10) continue;
                if(!visited[ny][nx][dir] && !visited[y][x][(dir+2)%4]) answer++;
                visited[ny][nx][dir] = true;
                visited[y][x][(dir + 2) % 4] = true;
                y = ny;
                x = nx;

            }
            return answer;
    }
}
