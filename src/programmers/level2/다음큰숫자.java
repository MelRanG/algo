package programmers.level2;

public class 다음큰숫자 {
    public int solution(int n) {
        int val = n;
        while (true){
            val++;
            if(Integer.bitCount(n) == Integer.bitCount(val)) break;
        }
        return val;
    }
}
