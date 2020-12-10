/*
	算法思想：
		可以暴力解决，但是没用到条件！！
		从左下角往上看，数字是变小的
		从上往下看，往右是递增的
		因此，用这个条件可以简化我们的答案
		
		这个与LeetCode74类似，但是之前的思路不是这个！！
*/

public class Solution {
    public boolean Find(int target, int [][] array) {
        int row = array.length;
        int col = array[0].length;

        int i = row-1;
        int j = 0;
        while(i >= 0 && j < col){
            if(array[i][j] == target){
                return true;
            }else if(array[i][j] < target)
                j++;
            else
                i--;
        }

        return false;
    }
}
