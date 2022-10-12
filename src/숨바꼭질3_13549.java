import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 숨바꼭질3_13549 {

    static int N, M;
    static int[] distance = new int[100001];
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Arrays.fill(distance, Integer.MAX_VALUE);
        dikstra();
        System.out.println(distance[M]);
    }

    private static void dikstra() {
        pq.add(new Node(N, 0));
        distance[N] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            distance[node.n] = node.d;
            if(node.n == M) return;

            if(node.n+1 <= 100000 && node.d+1 < distance[node.n+1]) pq.add(new Node(node.n+1, node.d+1));
            if(node.n-1 >= 0 && node.d-1 < distance[node.n-1]) pq.add(new Node(node.n-1, node.d+1));
            if(node.n*2 <= 100000 && node.d < distance[node.n*2]) pq.add(new Node(node.n*2, node.d));

        }
    }

    static class Node{
        int n, d;

        public Node(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }
}
