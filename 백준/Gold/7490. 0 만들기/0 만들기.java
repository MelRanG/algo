import java.io.*;
import java.util.*;
class Main {
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        while(N-- >0){
            M = Integer.parseInt(br.readLine());
            dfs("1",1,1,1,0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(String express,int idx, int num, int op, int sum){


        if(idx == M){
            sum += (op * num);
            if(sum == 0) sb.append(express + "\n");
            return;
        }
        dfs(express + " " + (idx+1),idx+1, num*10 + (idx+1), op, sum);
        dfs(express + "+" + (idx+1), idx+1, idx+1, 1, sum + (op * num));
        dfs(express + "-" + (idx+1), idx+1, idx+1, -1, sum + (op * num));
    }

}