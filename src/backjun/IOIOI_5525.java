package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IOIOI_5525 {

    static int N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        String ioi = br.readLine();
        int result = 0;
        int count = 0;
        for (int i = 0; i < M - 2; i++) {
            if(ioi.charAt(i) == 'I' && ioi.charAt(i) == ioi.charAt(i+2) && ioi.charAt(i) != ioi.charAt(i+1)){
                count++;

                if(count == N){
                    result++;
                    count--;
                }
                i++;
            }else count = 0;
        }
        System.out.println(result);
    }
}

