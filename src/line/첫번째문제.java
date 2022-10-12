package line;

//배열 복사 후 크기 부족하면 크기만큼 복사
public class 첫번째문제 {

    static Node[] arr = new Node[1001];

    public static void main(String[] args) {
        int[][] query = {{2,10}, {7,1}, {2,5}, {2,9}, {7,32}};
        System.out.println(solution(query));
    }

    public static int solution(int[][] queries) {
        int answer = 0;
        for (int i = 0; i < queries.length; i++) {
            //기존배열 원소수 + 새로운배열원소수가 기존 배열 크기보다 작다면
            if(arr[queries[i][0]] == null){
                arr[queries[i][0]] = new Node(queries[i][1], findPower(queries[i][1]));
            }
            else if(arr[queries[i][0]].count + queries[i][1] > arr[queries[i][0]].pow){
                answer += arr[queries[i][0]].count;
                arr[queries[i][0]].count = arr[queries[i][0]].count + queries[i][1];
                arr[queries[i][0]].pow = findPower(arr[queries[i][0]].count);
            }else{
                arr[queries[i][0]].count = arr[queries[i][0]].count + queries[i][1];
            }
        }
        return answer;
    }
    public static int findPower(int result){
        int firstPower = 1;
        if(result == 1) return 1;
        while(firstPower <= result){
            firstPower *= 2;
        }
        return firstPower;
    }

    static class Node{
        int count, pow;

        public Node(int count, int pow) {
            this.count = count;
            this.pow = pow;
        }
    }
}
