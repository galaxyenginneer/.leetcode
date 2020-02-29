import java.util.*;
class Solution {
    public String minNumber(int[] nums) {
        
        List<String> res=new ArrayList<>();
        for (int i=0;i<nums.length;i++) res.add(Integer.toString(nums[i]));
        Collections.sort(res,new Comparator<String>(){
            @Override
            public int compare(String a,String b){
                int i=0,j=0;
                while(i<a.length()-1 || j<b.length()-1){
                    if (a.charAt(i)<b.charAt(j)) return -1;
                    if (a.charAt(i)>b.charAt(j)) return 1;
                    i=i==a.length()-1?i:i+1;
                    j=j==b.length()-1?j:j+1;
                }
                return -1;
            }
        });
        String s="";
        for (int i=0;i<nums.length;i++) s+=res.get(i);
        return s;
    }
}