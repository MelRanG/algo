import java.io.*;
import java.util.*;
class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- >0){
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            if(K == 1) {
                System.out.println(1 + " " + 1);
                continue;
            }
            int[] alpha = new int[26];
            for (int i = 0; i < W.length(); i++) {
                alpha[W.charAt(i) - 'a']++;
            }
            int max = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < W.length(); i++) {
                if(alpha[W.charAt(i) - 'a'] < K) continue;
                int count = 1;
                for (int j = i+1; j < W.length(); j++) {
                    if(W.charAt(i) == W.charAt(j)) count++;
                    if(count == K){
                        max = Math.max(max, j - i + 1);
                        min = Math.min(min, j-i+1);
                        break;
                    }
                }
            }
            if(max == -1) System.out.println(-1);
            else System.out.println(min + " " + max);
        }
    }
}