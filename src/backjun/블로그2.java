package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 블로그2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int[] result = new int[2];
        //파랑일 때 true 빨강일 때 false
        boolean check = true;
        if(arr[0] == 'B') result[0]++;
        else{
            result[1]++;
            check = false;
        }
        for (int i = 1; i < N; i++) {
            if(arr[i-1] != arr[i]){
                if(check){
                    result[1]++;
                    check = false;
                }else{
                    result[0]++;
                    check = true;
                }
            }
        }
        if(result[0] <= result[1]){
            System.out.println(result[0]+1);
        }else{
            System.out.println(result[1]+1);
        }
    }
}
