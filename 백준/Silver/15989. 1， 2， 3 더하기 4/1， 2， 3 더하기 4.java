import java.io.*;
import java.util.*;
class Main {

    static int N, M;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int dp[][] = new int[10001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[2][1] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        while(t-- >0){
            N = Integer.parseInt(br.readLine());
            for (int i = 4; i <= N; i++) {
                dp[i][1] = 1;
                dp[i][2] = i/2;
                int sum = 0;
                for (int j = 1; j <= 3; j++) {
                    sum += dp[i-3][j];
                }
                dp[i][3] = sum;
            }
            int sum = 0;
            for (int i = 1; i <= 3; i++) {
                sum += dp[N][i];
            }
            System.out.println(sum);
        }
    }
}