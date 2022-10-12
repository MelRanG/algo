import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 미확인도착지_9370 {

    static int N,M,t,s,g,h;
    static int[] distance;
    static int[] destination;
    static List<List<Node>> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int k = 0; k < T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            for (int i = 0; i < N+1; i++) {
                list.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                list.get(a).add(new Node(b,c));
                list.get(b).add(new Node(a,c));
            }

            distance = new int[N+1];
            destination = new int[t];

            for (int i = 0; i < t; i++) {
                destination[i] = Integer.parseInt(br.readLine());
            }
            List<Integer> answer = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                //g,h h,g중 최단거리를 구하고 a,목적지까지 최단거리와 같다면 정답에 추가
                int aTob = dijkstra(s, g);
                aTob += dijkstra(g, h);
                aTob += dijkstra(h, destination[i]);

                int bToa = dijkstra(s, h);
                bToa += dijkstra(h, g);
                bToa += dijkstra(g, destination[i]);
                int result = Integer.MAX_VALUE;
                if(aTob < Integer.MAX_VALUE || bToa < Integer.MAX_VALUE){
                    result = Math.min(aTob, bToa);
                }

                int direct = dijkstra(s, destination[i]);
                if(result < Integer.MAX_VALUE && result == direct) answer.add(destination[i]);
            }
            answer.sort((a, b) -> a - b);
            for (int i: answer
                 ) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static int dijkstra(int start, int end){
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node>pq = new PriorityQueue<>((o1,o2) -> o1.d - o2.d);
        distance[start] = 0;
        pq.add(new Node(start, 0));
        boolean[] visited = new boolean[N+1];

        while (!pq.isEmpty()){
            Node node = pq.poll();
            if(node.d > distance[node.n] || visited[node.n]) continue;
            visited[node.n] = true;
            for (Node i: list.get(node.n)) {
                if(node.d + i.d > distance[i.n]) continue;
                distance[i.n] = node.d + i.d;
                pq.add(new Node(i.n, node.d + i.d));
            }
        }
        return distance[end];
    }

    static class Node{
        int n, d;

        public Node(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }
}
