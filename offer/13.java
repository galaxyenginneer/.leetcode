import java.util.*;
class Solution {
    boolean access[][];
    int k;
    int res=0;
    boolean get(int i,int j){
        if (i<0 || i==access.length) return true;
        if (j<0 || j==access[0].length) return true;
        return access[i][j];
    }
    void search(int i,int j){
        if (i<0 || i==access.length) return;
        if (j<0 || j==access[0].length) return;
        if (access[i][j]) return;
        String s=Integer.toString(i)+Integer.toString(j);
        int sum=0;
        for (int t=0;t<s.length();t++) sum+=s.charAt(t)-'0';
        access[i][j]=true;
        if (sum>k)return;else res++;
        search(i+1, j);
        search(i-1, j);
        search(i, j-1);
        search(i, j+1);
    }
    public int movingCount(int m, int n, int k) {
        // int res=0;
        this.k=k;
        access=new boolean[m][n];
        search(0, 0);
        return res==0?1:res;
    }
}