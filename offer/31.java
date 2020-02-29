
import java.util.*;
class Solution {
    // List<Integer> in,out;
    
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // Myclass in=new Myclass();
        // Myclass out=new Myclass();
        Stack<Integer> stack=new Stack<>();
        int p=0,q=0,top=0;
        Set<Integer> map=new HashSet<>(pushed.length);
        // Map<Integer,Boolean> map=new HashMap<>();
        // for(int i=0;i<pushed.length;i++) map.put(pushed[i], false);
        while(true){
            int t=popped[q];
            if(map.contains(t)){
                if (stack.peek()==t) {
                    map.remove(t);
                    stack.pop();
                    q++;
                    continue;
                }else return false;
            }
            while(pushed[p]!=t){
                map.add(pushed[p]);
                stack.add(pushed[p]);
                p++;
            }
            p++;
            q++;
        }
        return true;
    }
}
