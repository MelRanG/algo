package programmers.level3;

public class 네트워크 {
    static boolean[] visited;

    public static void main(String[] args) {
        int[][] node = {{1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println(solution(3, node));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;
            dfs(computers, n, i);
            answer++;
        }
        return answer;
    }

    public static void dfs(int[][] computers, int n, int index){
        visited[index] = true;
        for (int i = 0; i < n; i++) {
            if(visited[i] || computers[index][i] == 0) continue;
            dfs(computers, n, i);
        }
    }
}
