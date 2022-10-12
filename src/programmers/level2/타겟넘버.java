package programmers.level2;

public class 타겟넘버 {


    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        System.out.println(solution(arr, 3));
    }

    public static int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);

    }

    private static int dfs(int[] numbers, int index, int sum, int target) {
        if(index == numbers.length){
            if(sum == target) return 1;
            return 0;
        }

        return dfs(numbers, index+1, sum + numbers[index], target) + dfs(numbers, index+1, sum - numbers[index], target);
    }
}
