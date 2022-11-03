package programmers.level2;

import java.util.ArrayDeque;
import java.util.Arrays;

public class 프린터 {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {2,1,3,2}, 2));
    }

    public static int solution(int[] priorities, int location) {

        ArrayDeque<Node> deque = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            deque.add(new Node(priorities[i], i));
        }
        Arrays.sort(priorities);
        int lastIndex = priorities.length-1;
        int result = 0;
        while(true){
            Node node = deque.pollFirst();
            if(node.value != priorities[lastIndex]){
                deque.addLast(node);
            }else{
                result++;
                lastIndex--;
                if(node.index == location) return result;
            }
        }
    }

    static class Node{
        int value, index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
