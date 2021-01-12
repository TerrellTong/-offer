/*
	算法思想：
		分为两步，首先第一步，在root1中找到与root2的值想等的点，第二步，找到想等的点之后，我们再进行判断，如果root2遍历完成，则说明已经找完了。即true
		此时是root1遍历完了，但是root2没有遍历完，说明要返回false。 两者的值不相等的时候直接返回false！！，然后递归！
*/



/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1 != null && root2 != null){
            //此时root1的值，与root2的值相等，则判断是否是子结构
            if(root1.val == root2.val){
                result = doesTree1HaveTree2(root1,root2);
            }
            //如果result为false，则判断root1.left和root1.right是否还满足这个条件
            if(!result){
                result = HasSubtree(root1.left,root2);
            }
            if(!result){
                result = HasSubtree(root1.right,root2);
            }
        }
        
        return result;
    }
    
    public boolean doesTree1HaveTree2(TreeNode root1,TreeNode root2){
        //如果root2遍历完成，则说明已经找完了
        if(root2 == null)
            return true;
        //此时是root1遍历完了，但是root2没有遍历完，说明要返回false
        if(root1 == null)
            return false;
        if(root1.val != root2.val)
            return false;
        return doesTree1HaveTree2(root1.left,root2.left)&& doesTree1HaveTree2(root1.right,root2.right);
    }
}