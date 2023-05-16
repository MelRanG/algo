import java.io.*;
import java.util.*;
class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2) -> e1.dist - e2.dist);
        pq.add(new Node(1,0));
        dist[1] = 0;
        while (!pq.isEmpty()){
            Node node = pq.poll();
            //최단거리가 갱신됐는데 큐에서 빠져나온 노드가 최단거리보다 비용이 높다면 무시
            if(dist[node.node] < node.dist) continue;
            for (Node next: graph.get(node.node)) {
                if(dist[next.node] <= dist[node.node] + next.dist) continue;
                dist[next.node] = dist[node.node] + next.dist;
                pq.add(new Node(next.node, next.dist));
            }
        }
        System.out.println(dist[N]);

    }

    static class Node{
        int node, dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}