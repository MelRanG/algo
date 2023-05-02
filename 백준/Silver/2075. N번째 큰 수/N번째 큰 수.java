import java.io.*;
import java.util.*;
class Main {

    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                pq.add(-Integer.parseInt(st.nextToken()));
            }
        }
        int v = 0;
        for (int i = 0; i < N; i++) {
            v = -pq.poll();
        }
        System.out.println(v);
    }
}