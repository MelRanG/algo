package programmers.level3;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 여행경로 {

    static List<String> list = new LinkedList<>();

    static boolean[] visited;
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        System.out.println(solution(tickets));
    }

    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(list);
        answer = list.get(0).split(" ");
        return answer;
    }

    private static void dfs(String start, String target, String[][] tickets, int count) {
        if(count == tickets.length) {
            list.add(target);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if(visited[i] || !start.equals(tickets[i][0])) continue;
            visited[i]= true;
            dfs(tickets[i][1], target + " " + tickets[i][1], tickets, count+1);
            visited[i] = false;
        }
    }
}
