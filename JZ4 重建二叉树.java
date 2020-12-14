/*
	算法思想：
		之前做过，不知道做了多少遍，还是实现有问题！但是比之前强了，知道了大致的运算规则
		1）首先计算左子树的节点个数
		2）通过左子树的节点个数来判断下一次递归时应该怎么确定范围
		3）递归不满足条件的情况！！（preLeft > preRight || inLeft > inRight），直接返回null！！！
		
*/

public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return dfs(pre,in,0,pre.length-1,0,pre.length-1);
    }
    
    public TreeNode dfs(int[] pre,int[] in,int preLeft,int preRight,int inLeft,int inRight){
        if(preLeft > preRight || inLeft > inRight)
            return null;
        //在中序遍历中找到根结点的位置
        int mid = inLeft;
        while(in[mid] != pre[preLeft])
             mid++;
        //左子树节点的个数
        int leftNum = mid - inLeft;
        TreeNode root = new TreeNode(pre[preLeft]);
        root.left = dfs(pre,in,preLeft+1,preLeft+leftNum,inLeft,mid-1);
        root.right = dfs(pre,in,preLeft+leftNum+1,preRight,mid+1,inRight);
        return root;
    }
}
