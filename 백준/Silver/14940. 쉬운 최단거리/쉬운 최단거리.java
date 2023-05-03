import java.io.*;
import java.util.*;
class Main {

    static int N, M;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 2) {
                    q.add(new int[] {i,j,1});
                    continue;
                }
                arr[i][j] = n;
            }
        }
        boolean[][] visited = new boolean[N][M];
        while (!q.isEmpty()){
            int[] node = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = node[0] + dy[i];
                int nx = node[1] + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] || arr[ny][nx] == 0) continue;
                visited[ny][nx] = true;
                arr[ny][nx] = node[2];
                q.add(new int[] {ny,nx,node[2]+1});
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && arr[i][j] == 1) arr[i][j] = -1;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}