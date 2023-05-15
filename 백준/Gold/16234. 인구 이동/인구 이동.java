import java.io.*;
import java.util.*;
class Main {

    static int N,L,R;
    static int[][] arr;
    static boolean[][][] line;

    //북동남서
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        line = new boolean[N][N][4];
        int result = 0;
        while (true){
            open();
            boolean loop = true;
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(visited[i][j]) continue;
                    for (int k = 0; k < 4; k++) {
                        if(line[i][j][k]){
                            loop = false;
                            visited[i][j] = true;
                            bfs(i,j,visited);
                            break;
                        }
                    }
                }
            }
            if(loop) break;
            result++;
            close();
        }
        System.out.println(result);
    }

    static void open() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int ny = dy[k] + i;
                    int nx = dx[k] + j;
                    if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                    if(Math.abs(arr[i][j] - arr[ny][nx]) >= L && Math.abs(arr[i][j] - arr[ny][nx]) <= R){
                        line[i][j][k] =true;
                    }
                }
            }

        }
    }

    static void close() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int ny = dy[k] + i;
                    int nx = dx[k] + j;
                    if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                    line[i][j][k] = false;
                }
            }
        }
    }

    static void bfs(int y, int x, boolean[][] visited){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{y,x});
        q.add(new int[] {y,x});
        int sum = arr[y][x];
        int count = 1;
        while (!q.isEmpty()){
            int[] node = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = node[0] + dy[i];
                int nx = node[1] + dx[i];

                if(ny < 0 || ny >= N || nx < 0 || nx >= N || !line[node[0]][node[1]][i] || visited[ny][nx]) continue;
                visited[ny][nx] = true;
                sum += arr[ny][nx];
                count++;
                list.add(new int[] {ny,nx});
                q.add(new int[] {ny,nx});
            }
        }

        for (int[] node: list) {
            arr[node[0]][node[1]] = sum / count;
        }
    }
}