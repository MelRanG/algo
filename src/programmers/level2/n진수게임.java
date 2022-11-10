package programmers.level2;

public class n진수게임 {
    public static void main(String[] args) {
        System.out.println(solution(2,4,2,2));
    }

    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        int i = 0;
        int count = 0;
        while(true){
            String s = Integer.toString(i, n);
            s = s.toUpperCase();
            for (int j = 0; j < s.length(); j++) {
                if((count % m) + 1 == p) answer += s.charAt(j);
                if(answer.length() == t) return answer;
                count++;
            }
            i++;
        }
    }

}
