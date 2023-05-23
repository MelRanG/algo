import java.io.*;
import java.util.*;
class Main {
    static int N,M;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        bfs();
    }

    private static void bfs() {
        ArrayDeque<Node> fire = new ArrayDeque<>();
        ArrayDeque<Node> man = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 'F') fire.add(new Node(i,j,0));
                if(arr[i][j] == 'J') man.add(new Node(i,j,0));
            }
        }
        int result = 0;
        while (true){
            while (!fire.isEmpty() && fire.peek().cnt == result){
                Node fired = fire.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = dy[i] + fired.y;
                    int nx = dx[i] + fired.x;
                    if(ny < 0 || ny >= N || nx < 0 || nx >= M || arr[ny][nx] == '#' || arr[ny][nx] == 'F') continue;
                    arr[ny][nx] = 'F';
                    fire.add(new Node(ny,nx,fired.cnt+1));
                }
            }
            if(man.isEmpty()){
                System.out.println("IMPOSSIBLE");
                return;
            }
            while (!man.isEmpty() && man.peek().cnt == result) {
                Node move = man.poll();
                if (move.y == 0 || move.y == N - 1 || move.x == 0 || move.x == M - 1) {
                    System.out.println(result + 1);
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    int ny = dy[i] + move.y;
                    int nx = dx[i] + move.x;
                    if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                    if (arr[ny][nx] == '.') {
                        arr[ny][nx] = 'J';
                        man.add(new Node(ny, nx, move.cnt + 1));
                    }
                }
            }
            result++;
        }
    }

    static class Node{
        int y,x,cnt;

        public Node(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }
}

