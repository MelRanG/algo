function solution(n, control) {
    var answer = 0;
    for(var i=0; i<control.length; i++){
        if(control.charAt(i) === "w") n++;
        if(control.charAt(i) === "s") n--;
        if(control.charAt(i) === "d") n+=10;
        if(control.charAt(i) === "a") n-=10;
    }
    return n;
}