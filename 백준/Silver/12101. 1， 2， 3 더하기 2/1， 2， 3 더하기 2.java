import java.io.*;
import java.util.*;
class Main {

    static int N,M,count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        if(!dfs(0,"")) System.out.println(-1);;
    }

    static boolean dfs(int sum, String s){
        if(sum > N) return false;
        if(sum == N){
            count++;
            if(count == M){
                System.out.println(s.substring(1));
                return true;
            }
            return false;
        }

        for (int i = 1; i <= 3; i++) {
            if(dfs(sum+i, s + "+"+i)) return true;
        }
    return false;
    }

}