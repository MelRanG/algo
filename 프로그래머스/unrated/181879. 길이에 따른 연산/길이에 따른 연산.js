function solution(num_list) {
    var answer = 1;
    if(num_list.length > 10){
        num_list.forEach(n => answer += n);
        answer--;
    }else num_list.forEach(n => answer *= n);
    return answer;
}