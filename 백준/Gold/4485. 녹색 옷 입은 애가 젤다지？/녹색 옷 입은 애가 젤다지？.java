import java.io.*;
import java.util.*;
class Main {
    static int[][] visited, arr;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        while (true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            arr = new int[N][N];
            visited = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
                Arrays.fill(visited[i],Integer.MAX_VALUE);
            }
            bfs();
            cnt++;
            System.out.printf("Problem %d: %d \n",cnt,visited[N-1][N-1]);
        }
    }

    static void bfs(){
        PriorityQueue<int[]> q = new PriorityQueue<>((e1, e2) -> e1[2] - e2[2]);
        q.add(new int[]{0,0,arr[0][0]});
        visited[0][0] = arr[0][0];
        while (!q.isEmpty()){
            int[] node = q.poll();
            int y = node[0];
            int x = node[1];
            int value = node[2];

            for(int i=0; i<4; i++){
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx] <= value + arr[ny][nx]) continue;
                visited[ny][nx] = value + arr[ny][nx];
                q.add(new int[] {ny,nx,visited[ny][nx]});
            }
        }
    }

}

