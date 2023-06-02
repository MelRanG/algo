function solution(num_str) {
    var answer = 0;
    num_str = num_str.split("").map(x => answer += Number(x));

    return answer;
}