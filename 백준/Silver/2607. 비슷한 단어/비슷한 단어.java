import java.io.*;
import java.util.*;
class Main {

    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] alphabet = new int[26];
        String source = br.readLine();
        for (int i = 0; i < source.length(); i++) {
            alphabet[source.charAt(i) - 'A']++;
        }
        int result = 0;

        for (int i = 0; i < N-1; i++) {
            int[] check = alphabet.clone();
            String target = br.readLine();

            if(Math.abs(target.length()- source.length()) > 1) continue;
            int cnt = 0; // 기준값과 같은 알파벳 개수
            for (int j = 0; j < target.length(); j++) {
                int idx = target.charAt(j) - 'A';
                if(check[idx]>0){
                    cnt++;
                    check[idx]--;
                }
            }
            //target이 더 긴경우
            if(source.length()-1 == target.length() && cnt == target.length()) result++;
            //source가 더 긴경우
            else if(source.length()+1 == target.length() && cnt == source.length()) result++;
            //같은 경우
            else if(source.length() == target.length() && Math.abs(cnt - source.length()) <= 1) result++;
        }
        System.out.println(result);
        
    }
   

}