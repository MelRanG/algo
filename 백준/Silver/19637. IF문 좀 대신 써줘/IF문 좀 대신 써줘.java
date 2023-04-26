import java.io.*;
import java.util.*;
class Main {

    static int N, M;
    static Node[] nodes;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nodes = new Node[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            search(Integer.parseInt(br.readLine()), sb);
        }
        System.out.println(sb);
    }

    static void search(int value, StringBuilder sb){
        int left,right;
        left = 0; right = N;
        String result = "";
        while (left <= right){
            int mid = (left + right) /2;
            if(nodes[mid].value >= value){
                result = nodes[mid].order;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        sb.append(result).append("\n");
    }
    static class Node{
        String order;
        int value;
        public Node(String order, int value){
            this.order = order;
            this.value = value;
        }
    }
}