class Solution {
    public int[] solution(int[] sequence, int k) {
        int left,right,s,e,sum;
        left = right = s = e = sum = 0;
        int max = Integer.MAX_VALUE;
        int len = sequence.length;
        while(left < len){
            if(sum == k && max > right - left){
                s = left;
                e = right-1;
                max = right - left;
            }
            if(sum < k && right < len) sum += sequence[right++];
            else sum -= sequence[left++];
        }
        return new int[] {s,e};
    }
}