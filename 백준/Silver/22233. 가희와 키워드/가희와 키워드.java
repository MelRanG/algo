import java.io.*;
import java.util.*;
class Main {

    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            String[] arr = br.readLine().split(",");
            for (int j = 0; j < arr.length; j++) {
                set.remove(arr[j]);
            }
            System.out.println(set.size());
        }

    }

}