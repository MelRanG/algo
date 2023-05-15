import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<int[]> stack = new Stack<>();
		Queue<Integer> q = new LinkedList<>();
	
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int top = Integer.parseInt(st.nextToken());
			while(!stack.isEmpty()) {
				if(top < stack.peek()[0]) {
					System.out.print(stack.peek()[1] + " ");
					break;
				}
				else {
					stack.pop();
				}
			}
			
			if(stack.isEmpty()) System.out.print("0" + " ");
			stack.push(new int[] {top, i+1});
			
		}
		
	}
}