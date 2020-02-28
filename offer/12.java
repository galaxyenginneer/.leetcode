import java.util.*;
class Solution {
    char[][] board;
    String word;
    boolean res;
    Set<Integer> dp;
    boolean search(int i,int j,int k){
        if (i<0 | i==board.length) return false;
        if (j<0 | j==board[0].length) return false;
        if (dp.contains(i*board[0].length+j)) return false;
        if (board[i][j]!=word.charAt(k))return false;
        dp.add(i*board[0].length+j);
        if (k==word.length()-1) {
            res=true;
            return true;
        }
        if (search(i-1, j, k+1)) return true;
        if (search(i+1, j, k+1)) return true;
        if (search(i, j+1, k+1)) return true;
        if (search(i, j-1, k+1)) return true;
        dp.remove(i*board[0].length+j);
        return false;
    }
    public boolean exist(char[][] board, String word) {
        this.board=board;
        this.word=word;
        for (int i=0;i<board.length;i++)
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==word.charAt(0)){
                    dp=new HashSet<>();
                    search(i, j, 0);
                }
            }
        return res;
    }
}