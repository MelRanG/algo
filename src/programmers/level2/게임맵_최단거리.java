package programmers.level2;

import java.util.ArrayDeque;

public class 게임맵_최단거리 {

    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    static boolean[][] visited;

    public static void main(String[] args) {
        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        System.out.println(solution(maps));
    }
    public static int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];

        return bfs(maps);
    }

    private static int bfs(int[][] maps) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(0,0,0));
        while(!q.isEmpty()){
            Node node = q.poll();
            System.out.println(maps.length-1 + " " + node.x);
            if(node.y == maps.length-1 && node.x == maps[0].length-1) return node.v+1;
            for (int i = 0; i < 4; i++) {
                int ny = dy[i] + node.y;
                int nx = dx[i] + node.x;
                if(ny < 0 || ny >= maps.length || nx < 0 || nx >= maps[0].length || visited[ny][nx] || maps[ny][nx] == 0) continue;
                visited[ny][nx] = true;
                q.add(new Node(ny,nx,node.v+1));
            }
        }
        return -1;
    }

    static class Node{
        int y, x, v;

        public Node(int y, int x, int v) {
            this.y = y;
            this.x = x;
            this.v = v;
        }
    }
}
