package programmers.level2;

public class 멀리뛰기 {

    static long[] arr;

    public static void main(String[] args) {
        System.out.println(solution(1));
    }

    public static long solution(int n) {
        arr = new long[n+2];
        arr[1] = 1;
        arr[2] = 2;
        return recur(n);
    }

    static long recur(int index){
        if(arr[index] != 0) return arr[index];

        arr[index] = (recur(index - 1) + recur(index - 2)) % 1234567;
        return arr[index];
    }
}
