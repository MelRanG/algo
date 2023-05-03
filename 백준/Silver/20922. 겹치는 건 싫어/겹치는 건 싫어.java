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
        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int max = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            max = Math.max(max, map.get(arr[i]));
            while (max > M){
                map.put(arr[left], map.get(arr[left])-1);
                left++;
                max = map.get(arr[i]);
            }
            result = Math.max(result, (i - left) + 1);
        }
        System.out.println(result);
    }
}