/*
	算法思想：
		回溯，LeetCode之前做过！
*/



import java.util.ArrayList;
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
    ArrayList<ArrayList<Integer>> res = new ArrayList();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null)
            return res;
        dfs(root,new ArrayList(),0,target);
        return res;
    }
    
    public void dfs(TreeNode root,ArrayList<Integer> cur,int sum,int target){
        if(root == null)
            return;
        
        sum += root.val;
        cur.add(root.val);
        if(sum == target){
            //如果到达叶子节点，而且满足sum == target，加入路径
            if(root.left == null && root.right == null){
                res.add(new ArrayList(cur));
            }
            //不满足叶子节点，则不添加到res中
            cur.remove(cur.size()-1);
            sum -= root.val;
            return;
        }
        
        dfs(root.left,cur,sum,target);
        dfs(root.right,cur,sum,target);
        //回溯
        cur.remove(cur.size()-1);
        sum -= root.val;
    }
}