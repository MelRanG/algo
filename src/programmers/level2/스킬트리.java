package programmers.level2;

class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] arr = skill.toCharArray();
        for(int i=0; i < skill_trees.length; i++){
            //BACDE
            boolean check = true;
            int lastIndex = 0;
            for(int j = 0; j < skill_trees[i].length(); j++){
                //B
                char word = skill_trees[i].charAt(j);
                for(int k = 0; k < arr.length; k++){
                    //C
                    if(word == arr[k]){
                        if(lastIndex == k){
                            lastIndex++;
                        }else{
                            check = false;
                            break;
                        }
                    }
                }
            }
            if(check) answer++;
        }
        return answer;
    }
}
