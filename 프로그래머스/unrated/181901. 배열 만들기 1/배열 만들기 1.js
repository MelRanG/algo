function solution(n, k) {
    var answer = [];
    for(var i=1; i*k<=n; i++){
        answer.push(i*k);
    }
    return answer;
}