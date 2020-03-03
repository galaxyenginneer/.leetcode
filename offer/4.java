class Solution {
    int[][] matrix;
    boolean res;
    int target;
    boolean search(int a,int b,int c,int d){
        // System.out.println(a+" "+b+" "+c+" "+d);
        if (b+d-a-c<3){
            for(int i=a;i<=b;i++)
            for(int j=c;j<=d;j++){
                // System.out.println(matrix[i][j]);
                if(matrix[i][j]==target)return true;
            }
            return false;
        }
        int mid1=(a+b)/2,mid2=(c+d)/2;
        // System.out.println(matrix[mid1][mid2]);
        if (matrix[mid1][mid2]==target)return true;
        if (matrix[mid1][mid2]>target){
            if (matrix[a][mid2]<=target && search(a, mid1-1, mid2, d)) return true;
            if (matrix[mid1][c]<=target && search(mid1, b, c, mid2-1)) return true;
            if (a<=mid1-1 && c<=mid2-1 && search(a, mid1-1, c, mid2-1))return true;
        }else{
            if (matrix[mid1][d]>=target && search(a, mid1, mid2+1, d)) return true;
            if (matrix[b][mid2]>=target && search(mid1+1, b, c, mid2)) return true;
            if (b>=mid1+1 && d>=mid2-1 && search(mid1+1, b, mid2+1, d))return true;
        }
        return false;
    }
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length==0 || matrix[0].length==0)return false;
        int a=0,b=matrix.length-1,c=0,d=matrix[0].length-1;
        this.matrix=matrix;
        this.target=target;
        return search(a, b, c, d);
        // return res;
    }
}