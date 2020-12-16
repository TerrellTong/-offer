/*
	算法思想：
		简单的动态规划，记忆化搜索
*/


import java.util.*;
public class Solution {
    int[] memo;
    public int JumpFloor(int target) {
        memo = new int[target+1];
        Arrays.fill(memo,-1);
        return dfs(target);
    }
    
    public int dfs(int n){
        if(n < 0)
            return 0;
        if(n == 0)
           return 1;
        if(memo[n] != -1)
            return memo[n];
        
        memo[n] = dfs(n-1) + dfs(n-2);
        return memo[n];
    }
}