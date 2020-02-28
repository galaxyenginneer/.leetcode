import java.util.*;
class Solution {
    public int findNthDigit(int m) {
        int i=1,sum=0;
        long n=m,temp=9;
        if (n<10) return (int)n;
        while(true){
            n-=temp*i;
            if (sum>n) {
                n+=temp*i;
                break;
            }
            temp*=10;
            i++;
        }
        temp/=9;
        sum=(int)temp;
        temp=(int)Math.ceil(((double)n)/i)-1;
        sum+=temp;
        n-=temp*i;
        return Integer.toString(sum).charAt((int)n-1)-'0';
    }
}