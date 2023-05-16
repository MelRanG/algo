import java.io.*;
import java.util.*;
class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = N-1;
        int result1 = 0;
        int result2 = 0;
        while (left < right){
            if(min > Math.abs(arr[left] + arr[right])){
                result1 = arr[left];
                result2 = arr[right];
                min = Math.abs(arr[left] + arr[right]);
            }
            if(arr[left] + arr[right] >= 0)right--;
            else left++;
        }
        System.out.println(result1 + " " + result2);
    }

}