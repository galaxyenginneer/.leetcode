class Solution {
    public int translateNum(int num) {
        String s=Integer.toString(num);
        int a=0,b=1;
        for (int i=1;i<s.length();i++){
            int temp=(s.charAt(i-1)-'0')*10+s.charAt(i)-'0';
            if (temp<26 && temp>9) {
                if (i%2==0) b=a+b;else a=a+b;
            }
            if (i%2==0) b=a;else a=b;
        }
        return s.length()%2==0?a:b;
    }
}