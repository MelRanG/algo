import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;
        int result = 200000;
        while (true){
            if(sum >= M){
                sum -= arr[left++];
                count--;
            }else if(right > N-1) break;
            else if(sum < M){
                sum += arr[right++];
                count++;
            }
            if(sum >= M) result = Math.min(result,count);
        }
        if(result == 200000) System.out.println(0);
        else System.out.println(result);

    }
}