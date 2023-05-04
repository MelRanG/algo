import java.io.*;
import java.util.*;
class Main {

    static int N, M;
    static int min;
    static Road[] roads;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        roads = new Road[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            roads[i] = new Road(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(roads, (e1, e2) -> (e1.start - e2.start));
        min = Integer.MAX_VALUE;
        dfs(0,0);
        System.out.println(min);
    }

    static void dfs(int distance, int start){
        if(start == M){
            min = Math.min(min, distance);
            return;
        }
        for (int i = 0; i < N; i++) {
            if(roads[i].start < start || roads[i].end > M || roads[i].end - roads[i].start < roads[i].distance) continue;
            dfs(distance + (roads[i].start - start) + roads[i].distance, roads[i].end);
        }
        dfs(distance + (M - start), M);
    }

    static class Road{
        int start, end, distance;

        public Road(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
}