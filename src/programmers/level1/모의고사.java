package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {
    static int[] a = {1,2,3,4,5};
    static int[] b = {2,1,2,3,2,4,2,5};
    static int[] c = {3,3,1,1,2,2,4,4,5,5};

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3})[0]);
    }

    public static Integer[] solution(int[] answers) {
        Node[] answer = {new Node(0,1),new Node(0,2),new Node(0,3)};

        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == a[i%5]) answer[0].val++;
            if(answers[i] == b[i%8]) answer[1].val++;
            if(answers[i] == c[i%10]) answer[2].val++;
        }
        Arrays.sort(answer, (e1, e2) -> e2.val - e1.val);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if(answer[0].val == answer[i].val) list.add(answer[i].index);
        }
        System.out.println(list);
        return list.toArray(new Integer[list.size()]);
    }

    static class Node{
        int val, index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}
