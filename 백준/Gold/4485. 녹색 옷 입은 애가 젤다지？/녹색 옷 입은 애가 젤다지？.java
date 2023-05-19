
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.w - e2.w);
	static int[][] arr;
	static int[][] distance;
	
	static int[] dy = {1,0,0,-1};
	static int[] dx = {0,-1,1,0};
	
	public static void main(String[] args) throws Exception{
		int index = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int t = Integer.parseInt(br.readLine());
			if(t == 0) break;
			
			arr = new int[t][t];
			distance = new int[t][t];
			
			for (int i = 0; i < t; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < t; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < t; i++) {
				Arrays.fill(distance[i], Integer.MAX_VALUE);
			}
			distance[0][0] = arr[0][0];
			pq.add(new Edge(0,0,arr[0][0]));
			
			while(!pq.isEmpty()) {
				Edge edge = pq.poll();
				//이미 처리된 노드라면 컨티뉴
				if(distance[edge.y][edge.x] < edge.w) continue;
				
				for (int d = 0; d < 4; d++) {
					int ny = dy[d] + edge.y;
					int nx = dx[d] + edge.x;
					
					if(ny < 0 || ny >= t || nx < 0 || nx >= t) continue;
					
					int cost = arr[ny][nx] + edge.w;
					if(distance[ny][nx] > cost) {
						distance[ny][nx] = cost;
						pq.add(new Edge(ny,nx,cost));
					}
				}
			}
			index++;
			System.out.println("Problem "+index+": " + distance[t-1][t-1]);
			
		}
	}

	
	static class Edge{
		int y,x,w;

		public Edge(int y, int x, int w) {
			super();
			this.y = y;
			this.x = x;
			this.w = w;
		}
	}

}