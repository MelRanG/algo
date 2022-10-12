package programmers.level2;

import java.util.HashSet;

public class 소수찾기 {

    static boolean[] visited;
    static boolean[] prime = new boolean[10000000];
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(solution("17"));
    }

    public static void isPrime(){
        prime[0] = prime[1] = true;
        for (int i = 2; i*i < prime.length; i++) {
            if(!prime[i]){
                for (int j = i*i; j < prime.length; j+=i) {
                    prime[j] = true;
                }
            }
        }
    }
    public static int solution(String numbers) {
        visited = new boolean[numbers.length()];
        isPrime();
        dfs(numbers, "");
        return set.size();
    }

    public static void dfs(String numbers, String num){
        if(num.length() > 0 && !isPrime(num)){
            set.add(Integer.parseInt(num));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(numbers, num + numbers.charAt(i));
            visited[i] = false;
        }
    }

    private static boolean isPrime(String num) {
        int n = Integer.parseInt(num);
        return prime[n];
    }
}
