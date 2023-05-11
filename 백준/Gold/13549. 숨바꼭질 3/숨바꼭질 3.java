import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((e1, e2) -> e1.count - e2.count);
        pq.add(new Node(N,0));
        visited[N] = 0;
        while (!pq.isEmpty()){
            Node node = pq.poll();
            if(node.now == M){
                System.out.println(node.count);
                break;
            }
            if(node.now * 2 < 100001 && node.now * 2 < M*2 && visited[node.now * 2] > node.count){
                pq.add(new Node(node.now*2, node.count));
                visited[node.now*2] = node.count;
            }
            if(node.now-1 >= 0 && visited[node.now-1] > node.count+1){
                pq.add(new Node(node.now-1, node.count+1));
                visited[node.now-1] = node.count+1;
            }
            if(node.now+1 < 100001 && visited[node.now+1] > node.count+1){
                pq.add(new Node(node.now+1, node.count+1));
                visited[node.now+1] = node.count+1;
            }
        }
    }

    static class Node{
        int now, count;
        public Node(int now, int count){
            this.now = now;
            this.count = count;
        }
    }
}