import java.io.*;
import java.util.*;
class Main {

    static String a, b;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        a = br.readLine();
        b = br.readLine();

        dfs(a,b);
        if(flag) System.out.println(1);
        else System.out.println(0);

    }

    private static void dfs(String a, String b) {
        if(b.length() == a.length()) {
            if(a.equals(b)) flag = true;
            return;
        }
        if(!flag){
            if(b.charAt(b.length()-1) == 'A'){
                dfs(a,b.substring(0,b.length()-1));
            }
            if(b.charAt(0) == 'B'){
                String sb = new StringBuilder(b.substring(1)).reverse().toString();
                dfs(a,sb);
            }
        }
    }
}