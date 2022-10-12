package programmers.level3;

import java.util.*;

public class 베스트앨범 {
    public static void main(String[] args) {
        String[] g = {"classic", "pop", "classic", "classic", "pop"};
        int[] p = {500, 600, 150, 800, 2500};

        System.out.println(solution(g, p));
    }

    public static List solution(String[] genres, int[] plays) {
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[genres.length];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }

        //정렬을 위한 리스트화
        List<Node> genre = new ArrayList<>();
        for (String m:map.keySet()) {
            genre.add(new Node(m, map.get(m)));
        }
        Collections.sort(genre, (e1, e2) -> (e2.value - e1.value));
        List<Node> result = new ArrayList<>();
        //최종 값을 위해서 클래스에 삽입
        for (int i = 0; i < genres.length; i++) {
            result.add(new Node(genres[i], plays[i], i));
        }

        //최종 정렬
        Collections.sort(result, (e1, e2) -> e2 == e1 ? e1.index - e2.index : e2.value - e1.value);
        int count = 0;
        for (int i = 0; i < genre.size(); i++) {
            String type = genre.get(i).genre;
            for (int j = 0; j < result.size(); j++) {
                if(count == 2) break;
                if(result.get(j).genre.equals(type)){
                    list.add(result.get(j).index);
                    count++;
                }
            }
            count = 0;
        }
        return list;
    }

    static class Node{
        String genre;
        int value;
        int index;

        public Node(String genre, int value) {
            this.genre = genre;
            this.value = value;
        }

        public Node(String genre, int value, int index) {
            this.genre = genre;
            this.value = value;
            this.index = index;
        }
    }
}
