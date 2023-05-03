import java.io.*;
import java.util.*;
class Main {

    static int N, M;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = N-1; i >= 0; i--) {
            list.add(arr[i], i+1);
        }
        for (int i: list
             ) {
            System.out.print(i + " ");
        }
    }
}