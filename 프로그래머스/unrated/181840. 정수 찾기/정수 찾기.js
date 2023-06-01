function solution(num_list, n) {
    var answer = 0;
    num_list.forEach(e => {if(e==n) answer = 1});
    return answer;
}