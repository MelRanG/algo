package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 영단어암기는괴로워_20920 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if(s.length() < m) continue;
            map.put(s, map.getOrDefault(s, 0) +1);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (e1, e2) -> map.get(e2) - map.get(e1) == 0 ? e2.length() - e1.length() == 0 ?
                e1.compareTo(e2) : e2.length() - e1.length() : map.get(e2) - map.get(e1));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
