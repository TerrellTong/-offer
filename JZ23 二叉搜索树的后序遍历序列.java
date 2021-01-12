/*
	算法思想：
		根据后序遍历的最后一个位置的元素是根，而且二叉搜索树的特性是，左子树<根结点<右子树！！
		先找到第一个大于根结点的值，然后递归！
*/



public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0)
            return false;
        
        return dfs(sequence,0,sequence.length-1);
    }
    
    public boolean dfs(int[] sequence,int left, int right){
        //如果越界了，说明此时为true，因为之前触发false的条件都没有触发！
        if(left > right)
             return true;
        int root = sequence[right];
        //从左到右找到第一个大于根结点的位置
        int mid = left;
        while(sequence[mid] < root)
            mid++;
        
        //此时mid为大于根结点的位置
        int t = mid;
        while(t < right){
            //如果t的位置比root小，说明此时一定不会是二叉搜素树
            if(sequence[t] < root)
                return false;
            t++;
        }
        return dfs(sequence,left,mid-1)&&dfs(sequence,mid,right-1);
    }
    
    
}