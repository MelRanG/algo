import java.io.*;
import java.util.*;
class Main {
    static boolean[][] floor = {
        {true,true,true,false,true,true,true},
        {false,false,true,false,false,false,true},
        {false,true,true,true,true,true,false},
            {false,true,true,true,false,true,true},
            {true,false,true,true,false,false,true},
            {true,true,false,true,false,true,true},
            {true,true,false,true,true,true,true},
            {false,true,true,false,false,false,true},
            {true,true,true,true,true,true,true},
            {true,true,true,true,false,true,true}};

    static int N,K,P,X;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        int[] xToDigit = numToDigit(X);
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if(change(xToDigit, i)) {
                result++;
            }
        }
        System.out.println(result-1);
    }

    private static boolean change(int[] xToDigit, int i) {
        int[] nToDigit = numToDigit(i);
        int diffCount = 0;
        for (int j = 0; j < K; j++) {
            for (int k = 0; k < 7; k++) {
                if(floor[nToDigit[j]][k] != floor[xToDigit[j]][k]) diffCount++;
                if(diffCount > P) return false;
            }
        }
        return true;
    }

    static int[] numToDigit(int x){
        int[] arr = new int[K];
        for (int i = K-1; i >= 0; i--) {
            arr[i] = x%10;
            x /= 10;
        }
        return arr;
    }
}

