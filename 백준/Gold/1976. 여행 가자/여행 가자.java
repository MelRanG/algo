import java.io.*;
import java.util.*;
class Main {
    static int N,M;
    static int[][] graph;
    static int[] target;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        target = new int[M];
        for (int i = 1; i < N+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
           target[i] = Integer.parseInt(st.nextToken());
        }

        dfs(target[0],1);
        System.out.println("NO");
    }

    static void dfs(int start, int destination){
        if(destination == M){
            System.out.println("YES");
            System.exit(0);
            return;
        }
        visited[start] = true;
        if(graph[start][target[destination]] == 1 || start == target[destination]){
            visited = new boolean[N+1];
            dfs(target[destination], destination+1);
            return;
        }
        for (int i = 1; i < N+1; i++) {
            if(visited[i] || graph[start][i] == 0) continue;
            dfs(i, destination);
        }
    }
}

