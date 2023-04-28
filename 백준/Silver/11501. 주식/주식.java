import java.io.*;
import java.util.*;
class Main {

    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                stack.push(Integer.parseInt(st.nextToken()));
            }
            int max = 0;
            long result = 0;

            while (!stack.isEmpty()){
                int value = stack.pop();
                if(max < value){
                    max = value;
                }else{
                    result += max - value;
                }
            }
            System.out.println(result);
        }
    }

}