import java.io.*;
import java.util.*;
class Main {

    static int N, M;
    static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int red, blue;
        red = blue = 0;

        for (int i = 0; i < N; i++) {
            char color = s.charAt(i);
            if(color == 'R') red++;
            else blue++;
        }
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(s.charAt(i) == 'R') cnt++;
            else break;
        }
        min = Math.min(min, red - cnt);

        cnt = 0;
        for (int i = N-1; i >= 0; i--) {
            if(s.charAt(i) == 'R') cnt++;
            else break;
        }
        min = Math.min(min, red - cnt);
        cnt = 0;
        for (int i = 0; i < N; i++) {
            if(s.charAt(i) == 'B') cnt++;
            else break;
        }
        min = Math.min(min, blue - cnt);
        cnt = 0;
        for (int i = N-1; i >= 0; i--) {
            if(s.charAt(i) == 'B') cnt++;
            else break;
        }
        min = Math.min(min, blue - cnt);

        System.out.println(min);
    }
}