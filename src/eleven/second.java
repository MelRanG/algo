package eleven;

/**
 * 1, 2, ...의 용량을 가진 N개의 빈 잔이 있다.
 * N리터(각각 고유한 용량의 컵이 정확히 1개입니다. 당신은 컵에 정확히 K리터의 물을 붓고 싶어한다.
 * 각 잔은 가득 차거나 비어 있을 수 있습니다(잔은 부분적으로 채울 수 없음).
 * 당신이 K리터의 물을 담기 위해 필요한 최소 유리잔의 수는 몇 개입니까?
 */
public class second {
    public int solution(int N, int K) {
        int count = 0;
        for (int i = N; i > 0; i--) {
            if(K - i >= 0) {
                K-=i;
                count++;
            }
            if(K == 0) break;
        }
        if(K == 0) return count;
        else return -1;
    }
}
