import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=420 lang=java
 *
 * [420] 强密码检验器
 *
 * https://leetcode-cn.com/problems/strong-password-checker/description/
 *
 * algorithms
 * Hard (12.54%)
 * Likes:    25
 * Dislikes: 0
 * Total Accepted:    886
 * Total Submissions: 6.1K
 * Testcase Example:  '""'
 *
 * 一个强密码应满足以下所有条件：
 * 
 * 
 * 由至少6个，至多20个字符组成。
 * 至少包含一个小写字母，一个大写字母，和一个数字。
 * 同一字符不能连续出现三次 (比如 "...aaa..." 是不允许的, 但是 "...aa...a..." 是可以的)。
 * 
 * 
 * 编写函数 strongPasswordChecker(s)，s 代表输入字符串，如果 s 已经符合强密码条件，则返回0；否则返回要将 s
 * 修改为满足强密码条件的字符串所需要进行修改的最小步数。
 * 
 * 插入、删除、替换任一字符都算作一次修改。
 * 
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// @lc code=start
class Solution {
    public int strongPasswordChecker(String s) {
        boolean[] rule=new boolean[3];
        int result=0,delete=0,add=0;
        char p=255;
        int tmp=1;
        int num=s.length();
        System.out.println(num);
        char left=255,right=255;
        // s=s+(char)255;
        List<Integer> todo=new ArrayList<Integer>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)<='9' & s.charAt(i)>='0') rule[0]=true;
            if (s.charAt(i)<='Z' & s.charAt(i)>='A') rule[1]=true;
            if (s.charAt(i)<='z' & s.charAt(i)>='a') rule[2]=true;
            left=i==0?255:s.charAt(i-1);
            right=i==s.length()-1?255:s.charAt(i+1);
            if (s.charAt(i)==left){
                tmp++;
            }else{
                if (tmp>2) todo.add(tmp);
                tmp=1;
            }
        }
        if (tmp>2) todo.add(tmp);
        System.out.println(todo.toString());
        for (int i=0;i<3;i++) if (rule[i]==false) add++;
        add=Math.max(6-num,add);
        delete=Math.max(0,num-20);
        System.out.println(delete);
        System.out.println(add);
        // Collections.sort(todo);
        
        // todo.add(Integer.MAX_VALUE);
        for (int i=0;i<todo.size();i++){
            if (delete==0) break;
            if (todo.get(i)%3==0){
                todo.set(i,todo.get(i)-1);
                delete--;
                result++;
                if (todo.get(i)==2) {
                    todo.remove(i);
                    i--;
                }
            }
        }
        for (int i=0;i<todo.size();i++){
            if (delete==0) break;
            if (todo.get(i)%3==1){
                int change=Math.min(2,delete);
                result+=change;
                delete-=change;
                todo.set(i,todo.get(i)-change);
                if (todo.get(i)==2) {
                    todo.remove(i);
                    i--;
                }
            }
        }
        Collections.sort(todo);
        System.out.println(todo.toString());
        for (int i=0;i<todo.size();i++){
            tmp=todo.get(i);
            // System.out.println(tmp);
            int change=Math.min(delete,tmp-2);
            result+=change;
            tmp-=change;
            delete-=change;
            tmp/=3;
            // System.out.println(tmp);
            result+=tmp;
            add=Math.max(0,add-tmp);
        }
        result+=add+delete;
        return result;
    }
}
// @lc code=end

