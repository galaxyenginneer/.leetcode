import java.util.*;

class Solution {
    // char[]now;
    Set<String> res=new HashSet<>();
    char [] chars;
    void search(int ind){
        if (ind==chars.length-1){
            res.add(new String(chars));
            return;
        }
        char t;
        search(ind+1);
        for (int i=ind+1;i<chars.length;i++){
            t=chars[ind];
            chars[ind]=chars[i];
            chars[i]=t;
            search(ind+1);
            t=chars[ind];
            chars[ind]=chars[i];
            chars[i]=t;
        }
    }
    public String[] permutation(String s) {
        chars=s.toCharArray();
        search(0);
        return (String[])res.toArray(new String[0]);
    }

}