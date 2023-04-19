import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[][][] dp = new int[N][M][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            for (int d = 0; d < 3; d++) {
                dp[0][i][d] = arr[0][i];
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int d = 0; d < 3; d++) {
                    int newRow = i - 1;
                    int newCol = j + d - 1;

                    if (newCol >= 0 && newCol < M) {
                        dp[i][j][d] = dp[newRow][newCol][(d + 1) % 3] + arr[i][j];
                        dp[i][j][d] = Math.min(dp[i][j][d], dp[newRow][newCol][(d + 2) % 3] + arr[i][j]);
                    } else {
                        dp[i][j][d] = 1000 * 1000 + 1; // 초기값을 매우 큰 값으로 설정
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            for (int d = 0; d < 3; d++) {
                result = Math.min(result, dp[N - 1][i][d]);
            }
        }
        System.out.println(result);
    }
}