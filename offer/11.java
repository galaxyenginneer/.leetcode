class Solution {
    public int minArray(int[] numbers) {
        int res=numbers.length>0?numbers[0]:0;
        for (int i=1;i<numbers.length;i++){
            if(numbers[i]>numbers[i-1]){
                res=numbers[i];
                break;
            }
        }
        return res;
    }
}