import java.io.*;
import java.util.*;
class Main {

    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int T = Integer.parseInt(br.readLine());
        ArrayDeque<Character> s1 = new ArrayDeque<>();
        ArrayDeque<Character> s2 = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            s1.addLast(s.charAt(i));
        }
        while (T-- >0){
            String order = br.readLine();
            switch (order){
                case "L":
                    if(!s1.isEmpty()) s2.addLast(s1.pollLast());
                    break;
                case "D":
                    if(!s2.isEmpty()) s1.addLast(s2.pollLast());
                    break;
                case "B":
                    if(!s1.isEmpty()) s1.pollLast();
                    break;
                default:
                    StringTokenizer st = new StringTokenizer(order, " ");
                    st.nextToken();
                    char c = st.nextToken().charAt(0);
                    s1.addLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!s1.isEmpty()){
            sb.append(s1.pollFirst());
        }
        while (!s2.isEmpty()){
            sb.append(s2.pollLast());
        }
        System.out.println(sb);
    }
}