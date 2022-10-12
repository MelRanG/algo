package programmers.level2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class 전력망을_둘로_나누기 {

    static int[][] arr;

    public static void main(String[] args) {
        int[][] wires = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
        System.out.println(solution(7, wires));
    }

    public static int solution(int n, int[][] wires) {
        int answer = n;
        arr = new int[n+1][n+1];
        for (int i = 0; i < wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        for (int i = 0; i < wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 0;
            arr[wires[i][1]][wires[i][0]] = 0;
            answer = Math.min(bfs(wires[i][0], n), answer);
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        return answer;
    }

    private static int bfs(int index, int n) {
        boolean[] visited = new boolean[arr.length];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(index);
        int count = 1;
        while(!q.isEmpty()){
            int val = q.poll();
            visited[val] = true;
            for (int i = 0; i < arr.length; i++) {
                if(arr[val][i] == 0 || visited[i]) continue;
                q.add(i);
                count++;
            }
        }
        return Math.abs(n- 2 * count);
    }


}
