import java.util.*;

class Solution {
    List<Integer> res=new ArrayList<Integer>();
    public int remove(int val,int ind){
        if (ind>=res.size())return -1;
        for (int i=ind;i<res.size();i++){
            if (res.get(i)==val){
                res.remove(i);
                return i;
            }
            if (res.get(i)>val)return -1;
        }
        return -1;
    }
    public String largestMultipleOfThree(int[] digits) {
        int sum=0,i;
        String result="";
        
        List<Integer> s1=new ArrayList<Integer>();
        List<Integer> s2=new ArrayList<Integer>();
        Arrays.sort(digits);
        for (i=0;i<digits.length;i++){
            sum+=digits[i];
            res.add(digits[i]);
            if (digits[i]%3==1) s1.add(digits[i]);
            if (digits[i]%3==2) s2.add(digits[i]);
        }
        if (sum<3)return "";
        if (sum%3==1){
            if (s1.size()>0){
                // int tmp=s1.get(0);
                remove(s1.get(0),0);
            }else{
                int tmp=remove(s2.get(0),0);
                remove(s2.get(1),tmp);
            }
        }if(sum%3==2){
            if (s2.size()>0){
                int tmp=s2.get(0);
                remove(tmp,0);
            }else{
                int tmp=remove(s1.get(0),0);
                remove(s1.get(1),tmp);
            }        
        }
        for (i=res.size()-1;i>-1;i--){
            result=result+res.get(i);
        }
        return result;
    }
}