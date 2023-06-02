function solution(my_string, index_list) {
    var answer = '';
    index_list.forEach((e) => answer += my_string[e]);
    return answer;
}