package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 테트로미노_14500 {
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};

    static int[][] arr;
    static boolean[][] visited;
    static int N,M;
    static int max;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        String s = "sdfsd";

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j]= true;
                dfs(i,j,arr[i][j],1);
                visited[i][j]= false;
            }
        }
        System.out.println(max);
    }

    private static void dfs(int y, int x, int sum, int count) {
        if(count == 4){
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) continue;
            visited[ny][nx] = true;
            if(count == 2){
                dfs(y, x, sum + arr[ny][nx], count+1);
            }
            dfs(ny, nx, sum + arr[ny][nx], count+1);
            visited[ny][nx] = false;
        }

    }
}
