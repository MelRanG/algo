import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        List<List<Integer>> list = new ArrayList<>();
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for(int i=0; i<=n; i++) list.add(new ArrayList<>());
        for(int[] e : edge){
            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }
        pq.add(new int[] {1,0});
        distance[1] = 0;
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            if(distance[node[0]] < node[1]) continue;

            for(int next : list.get(node[0])){
                if(distance[next] <= node[1]+1) continue;
                pq.add(new int[] {next, node[1]+1});
                distance[next] = node[1]+1;
            }
        }
        Arrays.sort(distance);
        int max = 0;
        int result = 0;
        for(int i=n; i>=0; i--){
            if(distance[i] == Integer.MAX_VALUE) continue;
            if(distance[i] >= max){
                result++;
                max = distance[i];
            }
        }
        return result;
    }
}