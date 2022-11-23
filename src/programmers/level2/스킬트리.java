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
                int index = skill.indexOf(skill_trees[i].charAt(j));
                if(index == -1) continue;
                if(index == lastIndex) lastIndex++;
                else check = false;
            }
            if(check) answer++;
        }
        return answer;
    }

}