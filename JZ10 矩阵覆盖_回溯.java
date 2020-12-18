/*
	算法思想：
		简单回溯
*/

public class Solution {
    int count = 0;
    public int RectCover(int target) {
        if(target == 0)
             return 0;
        dfs(0,target);
        return count;
    }
    
    public void dfs(int sum,int target){
        if(sum == target){
            count++;
            return;
        }
        
        if(sum > target)
            return;
        
        for(int i=1;i<=2;i++){
            sum = sum+i;
            dfs(sum,target);
            sum = sum-i;
        }
    }
}