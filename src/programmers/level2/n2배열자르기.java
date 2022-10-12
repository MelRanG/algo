package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class n2배열자르기 {

    public static void main(String[] args) {
        System.out.println();
    }

    public List<Long> solution(int n, long left, long right) {

        List<Long> list = new ArrayList<>();

        for(long i=left;i<right+1;i++){
            list.add(Math.max(i/n,i%n) + 1);
        }

        return list;
    }
}
