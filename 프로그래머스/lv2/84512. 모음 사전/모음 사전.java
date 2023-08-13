class Solution {
    static int count;
    public int solution(String word) {
        dfs("", word);
        return count;
    }
    static boolean dfs(String s, String word){
        if(s.equals(word)) return true;
        if(s.length() == 5) return false;
        for(int i=0; i < 5; i++){
            count++;
            if(dfs(s + "AEIOU".charAt(i), word)) return true;
        }
        return false;
    }
}