class Solution {
    public int numWays(int n) {
        if (n<3) return Math.max(1,n);
        int a=1,b=2,c,max=(int)1e9+7;
        for (int i=0;i<n-2;i++){
            if (i%2==0) a=(a+b)%max;
            else b=(a+b)%max;
        }
        return n%2==0?b:a;
    }
}