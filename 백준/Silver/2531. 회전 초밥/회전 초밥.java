import java.io.*;
import java.util.*;
class Main {

    static int N, M;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] type = new int[d+1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int cnt = 1;
        int left = 0;
        int right = 0;
        type[c]++;
        for (int i = 0; i < k; i++) {
            if(type[arr[i]] == 0) cnt++;
            type[arr[i]]++;
            right = (right+1) % N;
        }

        while(left < N){
            max = Math.max(max, cnt);
            type[arr[left]]--;
            if(type[arr[left++]] == 0) cnt--;
            if(type[arr[right]] == 0) cnt++;
            type[arr[right]]++;
            right = (right+1) % N;
        }
        System.out.println(max);
    }
}
