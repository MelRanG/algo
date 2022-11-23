package programmers.level2;

import java.util.*;
class 미완_프렌즈4블록 {
    static int[] dy = {0,0,1,1};
    static int[] dx = {0,1,1,0};

    static ArrayDeque<Node> q = new ArrayDeque<>();

    public static void main(String[] args) {
        String[] arr = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        System.out.println(solution(4,5,arr));
    }

    public static int solution(int m, int n, String[] board) {
        char[][] arr = new char[board.length][];

        for(int i=0; i < board.length; i++){
            arr[i] = board[i].toCharArray();
        }
        int count = 0;
        for(int k=0; k < m; k++){
            for(int i=0; i < m; i++){
                for(int j=0; j < n; j++){
                    if(check(arr, i, j, arr[i][j])){
                        addBlock(i, j);
                    }
                }
            }

            while(!q.isEmpty()){
                Node node = q.poll();
                arr[node.y][node.x] = '.';
            }
            for (int i = m-1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                        if(arr[i][j] == '.'){
                            q.add(new Node(i, j));
                        }
                    }
                }

            while(!q.isEmpty()){
                Node node = q.poll();
                for (int i = node.y-1; i < m-1; i++) {
                    arr[i][node.x] = arr[i+1][node.x];
                }
            }

            for(int i=0; i < m; i++){
                for(int j=0; j < n; j++) {
                    if(arr[i][j] == '.'){
                        arr[i][j] = '#';
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == '#') count++;
            }
        }
        return count;
    }

    static boolean check(char[][] arr, int y, int x, char begin){
        for(int d = 0; d < 4; d++){
            int ny = dy[d] + y;
            int nx = dx[d] + x;
            if(ny < 0 || ny >= arr.length || nx < 0 || nx >= arr[0].length ||
                    arr[ny][nx] == '#' || begin != arr[ny][nx]) return false;
        }
        return true;
    }

    static void addBlock(int y, int x){
        for(int d = 0; d < 4; d++){
            int ny = dy[d] + y;
            int nx = dx[d] + x;
            q.offer(new Node(ny, nx));
        }
    }

    static class Node{
        int y,x;
        public Node(int y, int x){
            this.y = y;
            this.x = x;
        }

    }
}
