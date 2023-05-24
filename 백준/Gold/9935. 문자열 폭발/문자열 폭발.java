import java.io.*;
import java.util.*;
class Main {
    static String N,M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        N = br.readLine();
        M = br.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < N.length(); i++) {
            stack.push(N.charAt(i));
            if(stack.size() >= M.length()){
                boolean flag = true;
                String temp = "";
                for (int j = M.length()-1; j >= 0; j--) {
                    if(stack.peek() != M.charAt(j)) {
                        flag = false;
                        break;
                    }
                    temp += stack.pop();
                }
                if(!flag){
                    for (int j = temp.length()-1; j >= 0; j--) {
                        stack.push(temp.charAt(j));
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pollLast());
        }
        if(sb.length() == 0) System.out.println("FRULA");
        else System.out.println(sb);

    }
}

