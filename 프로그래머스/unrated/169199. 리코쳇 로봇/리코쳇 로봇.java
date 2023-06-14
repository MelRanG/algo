import java.util.*;
class Solution {
    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    static boolean[][] visited;
    static char[][] matrix;
    
    static int N,M;
    
    public int solution(String[] board) {
        matrix = new char[board.length][];
        for(int i=0; i<board.length; i++) matrix[i] = board[i].toCharArray();
        N = matrix.length;
        M = matrix[0].length;
        visited = new boolean[N][M];
        ArrayDeque<Node> q = new ArrayDeque<>();
        //r위치 찾기
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(matrix[i][j] == 'R'){
                    q.add(new Node(i,j,0));
                    visited[i][j] = true;
                    break;
                }
            }
        }
        
        //bfs 탐색
        while(!q.isEmpty()){
            Node node = q.poll();
            if(matrix[node.y][node.x] == 'G') return node.cnt;
            for(int d=0; d<4; d++){
                int ny = dy[d] + node.y;
                int nx = dx[d] + node.x;
                
                //한 방향으로 끝까지 탐색
                Node moveNode = search(ny,nx,d,node.cnt);
                if(!visited[moveNode.y][moveNode.x]) {
                    q.add(moveNode);
                    visited[moveNode.y][moveNode.x] = true;
                }
            }
        }
        return -1;
    }
    
    static Node search(int y, int x, int index, int cnt){
        int ny = y;
        int nx = x;
        while(true){
            if(ny < 0 || ny >= N || nx < 0 || nx >= M || matrix[ny][nx] == 'D') break;
            ny += dy[index];
            nx += dx[index];
        }
        //끝이나 D에 도달했으면 한단계전에 위치시키기
        ny -= dy[index];
        nx -= dx[index];
        return new Node(ny,nx,cnt+1);
    }
    
    static class Node{
        int y,x,cnt;
        public Node(int y, int x, int cnt){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
        
        @Override
        public String toString(){
            return "Node = {" +"y="+this.y +" "
                +"x="+this.x +" "
                +"cnt="+this.cnt
                +"}";
        }
    }
    
    static void print(Object obj){System.out.println(obj.toString());}
}