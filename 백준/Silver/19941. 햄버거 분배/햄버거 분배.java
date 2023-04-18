import java.io.*;
import java.util.*;
class Main {

    static int N,M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        char[] arr = s.toCharArray();
        for (int i = 0; i < N; i++) {
            if(arr[i] == 'P'){
                int start = Math.max(i-M, 0);
                int end = Math.min(i+M, N-1);
                for (int j = start; j <= end; j++) {
                    if(arr[j] == 'H') {
                        arr[j] = 'C';
                        break;
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i] == 'C') result++;
        }
        System.out.println(result);
    }

}