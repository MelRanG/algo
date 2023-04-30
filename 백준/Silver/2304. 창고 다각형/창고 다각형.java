import java.io.*;
import java.util.*;
class Main {

    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        while(N-- >0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a] = b;
        }
        int max = 0, index = 0;
        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i]){
                max = arr[i];
                index = i;
            }
        }
        //왼쪽부터 탐색
        int leftMax = 0;
        int value = 0;
        for (int i = 0; i <= index; i++) {
            if(leftMax <= arr[i]) {
                value += arr[i];
                leftMax = arr[i];
            }
            else value += leftMax;
        }
        //오른쪽 탐색
        int rightMax = 0;
        for (int i = arr.length-1; i >= index; i--) {
            if(rightMax <= arr[i]) {
                value += arr[i];
                rightMax = arr[i];
            }
            else value += rightMax;
        }
        System.out.println(value - arr[index]);
    }
}