package programmers.level2;

public class 예상대진표 {


    public int solution(int n, int a, int b)
    {
        int count = 0;
        double c = a;
        double d = b;
        while(true){
            if(c == d) break;
            c = Math.ceil(c/2.0);
            d = Math.ceil(d/2.0);
            count++;
        }
        return count;

    }

}
