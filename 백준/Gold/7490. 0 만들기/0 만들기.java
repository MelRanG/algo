import java.io.*;
import java.util.*;
class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- >0){
            N = Integer.parseInt(br.readLine());
            dfs("1",0,1,1,1);
            System.out.println();
        }
    }

    static void dfs(String express, int sum, int value, int op, int depth){
        if(depth == N){
            sum += (op) * value;
            if(sum == 0){
                System.out.println(express);
            }
            return;
        }
        dfs(express + " " + (depth+1), sum, value*10 + depth+1,op,depth+1);
        dfs(express + "+"+(depth+1), sum+ op * value, depth+1, 1, depth+1);
        dfs(express + "-"+(depth+1), sum+ op * value, depth+1, -1, depth+1);

    }
}

