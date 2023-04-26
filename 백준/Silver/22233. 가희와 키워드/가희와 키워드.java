import java.io.*;
import java.util.*;
class Main {

    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }
        for (int i = 0; i < M; i++) {
            String[] arr = br.readLine().split(",");
            for (int j = 0; j < arr.length; j++) {
                if(map.containsKey(arr[j]) && map.get(arr[j]) == 1){
                    N--;
                    map.put(arr[j],0);
                }
            }
            System.out.println(N);
        }

    }

}