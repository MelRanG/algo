import java.io.*;
import java.util.*;
class Main {
//    static boolean[][] floor = {
//        {true,true,true,false,true,true,true},
//        {false,false,true,false,false,false,true},
//        {false,true,true,true,true,true,false},
//            {false,true,true,true,false,true,true},
//            {true,false,true,true,false,false,true},
//            {true,true,false,true,false,true,true},
//            {true,true,false,true,true,true,true},
//            {false,true,true,false,false,false,true},
//            {true,true,true,true,true,true,true},
//            {true,true,true,true,false,true,true}};

    static int[] arr;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N-1;
            while (left < right){
                if(left == i) left++;
                if(right == i) right--;
                if(left >= right) break;
                int sum = arr[left] + arr[right];
                if(sum < arr[i]) left++;
                if(sum == arr[i]){
                    result++;
                    break;
                }
                else if(sum > arr[i]) right--;
            }
        }
        System.out.println(result);
    }


}

