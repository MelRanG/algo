package programmers.level2;

public class 피로도 {

    static boolean[] visited;
    static int result;

    public static void main(String[] args) {
        int[][] d = {{80,20},{50,40},{30,10}};
        System.out.println(solution(80, d));
    }

    public static int solution(int k, int[][] dungeons) {

        visited = new boolean[dungeons.length];
        dfs(dungeons, 0, k);

        return result;
    }

    private static void dfs(int[][] dungeons, int count, int k) {
        for (int j = 0; j < dungeons.length; j++) {
            if(visited[j] || k < dungeons[j][0]) continue;
            visited[j] = true;
            dfs(dungeons, count+1, k - dungeons[j][1]);
            visited[j] = false;
        }
        result = Math.max(count, result);
    }

}
