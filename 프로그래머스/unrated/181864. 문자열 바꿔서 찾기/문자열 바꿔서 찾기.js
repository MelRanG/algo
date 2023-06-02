function solution(myString, pat) {
    var answer = 0;
    var arr = myString.split("");
    for(var i=0; i<arr.length; i++){
        if(arr[i] === 'A') arr[i] = 'B';
        else arr[i] = 'A';
    }
    if(arr.join("").includes(pat)) answer = 1;
    return answer;
}