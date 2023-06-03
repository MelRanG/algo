class Node{
    constructor(y,x,count){
        this.y = y;
        this.x = x;
        this.count = count;
    }
}
var dy = [0,0,1,-1];
var dx = [1,-1,0,0];

function solution(maps) {
    var answer = 0;
    const visited = new Set();
    const q = [];
    q.push(new Node(0,0,1));
    visited.add("0,0");
    while(q.length > 0){
        const node = q.shift();
        if(node.y === maps.length-1 && node.x === maps[0].length-1){
            return node.count;
        }
        
        for(var i=0; i<4; i++){
            var ny = node.y + dy[i];
            var nx = node.x + dx[i];
            if(ny >= maps.length || ny < 0 || nx >= maps[0].length || nx < 0 || visited.has(`${ny},${nx}`) || maps[ny][nx] == 0) continue;
            q.push(new Node(ny,nx,node.count+1));
            visited.add(`${ny},${nx}`);
        }
    }
    
    return -1;
}