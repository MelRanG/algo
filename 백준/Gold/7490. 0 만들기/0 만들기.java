import java.io.*;
import java.util.*;
class Main {
    static int N,max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- >0){
            N = Integer.parseInt(br.readLine());
            dfs(1,0,1,1,"1");
            System.out.println();
        }

    }

    static void dfs(int depth, int sum, int op,int num ,String s){
        if(depth == N){
            sum += (op * num);
            if(sum == 0) System.out.println(s);
            return;
        }
        dfs(depth+1, sum, op, num*10 + (depth+1), s + " " + (depth+1));
        dfs(depth+1, sum + op * num,1 ,depth+1,s + "+" + (depth+1));
        dfs(depth+1, sum + op * num,-1 ,depth+1,s + "-" + (depth+1));
    }


}

