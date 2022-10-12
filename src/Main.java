import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = new int[] {a,b};
        }
        Arrays.sort( arr, (a,b) -> (a[0] - b[0]));
        int result = 0;
        for (int i = 0; i < N; i++) {
            if(result <= arr[i][0]) result = arr[i][0] + arr[i][1];
            else result += arr[i][1];
        }
        System.out.println(result);
    }


}
