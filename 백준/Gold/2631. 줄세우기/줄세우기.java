

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] input = new int[N];
        for(int i=0;i<N;i++) input[i] = sc.nextInt();

        int[] dp = new int[N];
        dp[0] = 1;
        
        int result = 0;
        for (int i = 1; i < N; i++) {
        	dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(input[j] < input[i]) dp[i] = Math.max(dp[i], dp[j]+1);
			}
			result = Math.max(result, dp[i]);
		}
        
        System.out.println(N - result);
	}
}
