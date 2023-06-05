import java.io.*;
import java.util.*;
class Main {
    static int N;
    static int match[] = {5,3,4,1,2,0};
    static int[][] dice;
    static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dice = new int[N][6];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 6; i++) {
            int max = 0;
            for (int j = 0; j < 6; j++) {
                if(i == j || match[i] == j) continue;
                max = Math.max(dice[0][j], max);
            }
            dfs(i,1,max);
        }
        System.out.println(result);
    }

    private static void dfs(int up, int depth, int sum) {
        if(depth == N){
            result = Math.max(sum,result);
            return;
        }
        //이전 up 인덱스로 현재 down과 맞는 값의 인덱스 찾기
        int down = 0;
        for (int i = 0; i < 6; i++) {
            if(dice[depth-1][up] == dice[depth][i]) down = i;
        }
        //up과 down 제외한 max값 구하기
        int max = 0;
        for (int i = 0; i < 6; i++) {
            if(i == down || i == match[down]) continue;
            max = Math.max(max, dice[depth][i]);
        }
        dfs(match[down], depth+1, sum + max);
    }

}

