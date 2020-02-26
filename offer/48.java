class Solution {
    public int lengthOfLongestSubstring(String s) {
        int j,max,res=0,end;
        for(int i=0;i<s.length();i++){
            j=i;end=s.length();
            while(j<end){
                max=s.indexOf(s.charAt(j),j+1);
                max=max==-1?s.length():max;
                end=Math.min(max,end);
                j++;
            }
            res=Math.max(res, j-i);
        }
        return res;
    }
}