package programmers.level2;

public class N개의최소공배수 {

    public int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //최소공배수 = 두 수의 곱 / 두 수의 최대공약수
            answer = answer * arr[i] / gcd(answer, arr[i]);
        }
        return answer;
    }

    static int gcd(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
