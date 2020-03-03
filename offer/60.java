class Solution {
    public double[] twoSum(int n) {
        int[]now=new int[n];
        double[]dp=new double[5*n+1];
        int sum=0,i=0;
        for (i=0;i<n;i++)now[i]=1;
        dp[0]=1;
        while(true){
            i=n-1;
            while(i>-1 && ++now[i]==7) {
                now[i]=1;
                i--;
                sum-=5;
            }
            sum++;
            if (i==-1) break;
            dp[sum]+=1;
        }
        sum=(int)Math.pow(6,n);
        for(i=0;i<dp.length;i++){
            dp[i]/=sum;
        }
        return dp;
    }
}