function solution(num_list) {
    var answer = 0;
    var a = "";
    var b = "";
    for(var i=0; i<num_list.length; i++){
        if(num_list[i]%2 === 0) a += num_list[i];
        else b += num_list[i];
    }
    return Number(a) + Number(b);
}