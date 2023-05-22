import java.io.*;
import java.util.*;
class Main {
    static int[] couple = {5,3,4,1,2,0};
    static int[][] dice;
    static int N,max;

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
            int sum = 0;
            for (int j = 0; j < 6; j++) {
                if(i == j || couple[i] == j) continue;
                sum = Math.max(sum, dice[0][j]);
            }
            setDice(1,dice[0][i],sum);
        }
        System.out.println(max);
    }

    static void setDice(int depth,int up , int sum){
        if(depth == N){
            max = Math.max(sum, max);
            return;
        }
        int nextIdx = 0;
        for (int i = 0; i < 6; i++) {
            if(dice[depth][i] == up){
                nextIdx = i;
                break;
            }
        }
        int max = 0;
        int nextTop = couple[nextIdx];
        for (int i = 0; i < 6; i++) {
            if(i == nextIdx || i == couple[nextIdx]) continue;
            max = Math.max(max, dice[depth][i]);
        }

        setDice(depth+1, dice[depth][nextTop], sum+max);

    }

}

