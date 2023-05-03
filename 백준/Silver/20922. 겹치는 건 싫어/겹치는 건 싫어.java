import java.io.*;
import java.util.*;
class Main {

    static int N, M;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] arr2 = new int[100001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int max = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            arr2[arr[i]]++;
            max = Math.max(max, arr2[arr[i]]);
            while (max > M){
                arr2[arr[left]]--;
                left++;
                max = arr2[arr[i]];
            }
            result = Math.max(result, (i - left) + 1);
        }
        System.out.println(result);
    }
}