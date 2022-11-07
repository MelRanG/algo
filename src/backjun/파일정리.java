package backjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 파일정리 {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("\\.");
            map.put(s[1], map.getOrDefault(s[1], 0)+1);
        }
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); i++) {
            sb.append(keys.get(i) + " " + map.get(keys.get(i))).append("\n");
        }
        System.out.println(sb.toString());
    }


}
