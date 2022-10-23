package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;

public class 혼자놀기의달인 {
    static boolean[] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        int[] cards = {2,1,4,3,7,5,6};
        System.out.println(solution(cards));
    }

    public static int solution(int[] cards) {
        visited = new boolean[cards.length];
        for (int i = 0; i < cards.length; i++) {
            if(visited[i]) continue;
            dfs(cards, i, 0);
        }
        if (list.size() == 1) return 0;
        Collections.sort(list, Collections.reverseOrder());
        return list.get(0) * list.get(1);
    }

    private static void dfs(int[] cards, int index, int count) {
        if (visited[index]) {
            list.add(count);
            return;
        }
        visited[index] = true;
        dfs(cards, cards[index]-1, count+1);
    }
}
