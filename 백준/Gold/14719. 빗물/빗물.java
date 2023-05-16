import java.io.*;
import java.util.*;
class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = arr[0];
        int sum = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i < M; i++) {
            if(arr[i] < left) stack.push(arr[i]);
            else{
                while (!stack.isEmpty()){
                    sum += left - stack.pop();
                }
                left = arr[i];
            }
        }
        if(!stack.isEmpty()){
            int right = stack.pop();
            while (!stack.isEmpty()){
                int v = stack.pop();
                if(right < v) right = v;
                else sum += right - v;
            }
        }
        System.out.println(sum);

    }
}