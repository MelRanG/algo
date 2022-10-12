package programmers.level3;

import java.util.ArrayDeque;

public class 단어변환 {

    public static void main(String[] args) {
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(solution("hit", "cog", words));
    }

    public static int solution(String begin, String target, String[] words) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        q.add(new Node(begin, 0));

        while (!q.isEmpty()){
            Node node = q.poll();
            if(node.s.equals(target)) return node.v;
            for (int i = 0; i < words.length; i++) {
                if(visited[i] || !check(node.s, words[i])) continue;
                visited[i] = true;
                q.add(new Node(words[i], node.v+1));
            }
        }
        return 0;
    }

    static boolean check(String begin, String target){
        int count = 0;
        for (int i = 0; i < begin.length(); i++) {
            if(begin.charAt(i) != target.charAt(i)) count++;
            if(count == 2) return false;
        }
        return true;
    }

    static class Node{
        String s;
        int v;

        public Node(String s, int v) {
            this.s = s;
            this.v = v;
        }
    }
}
