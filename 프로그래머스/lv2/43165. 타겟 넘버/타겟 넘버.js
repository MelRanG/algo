var t = 0;
var answer = 0;
function solution(numbers, target) {
    t = target;
    dfs(0,numbers,0);
    return answer;
}

function dfs(depth, numbers,sum){
    if(depth == numbers.length){
        if(sum === t) answer++;
        return;
    }
    dfs(depth+1, numbers, sum + numbers[depth]);
    dfs(depth+1, numbers, sum - numbers[depth]);
}