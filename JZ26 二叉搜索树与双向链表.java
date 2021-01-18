/*
	算法思想：
		Convert函数的功能：将一个二叉搜索树转换成有序的双向链表，返回链表的头结点
		pLast记录当前链表的末尾节点
		
		根结点的left，相当于是指向双向链表的前节点
		根节点的right，相当于是指向双向链表的后继节点
		
	题解：https://www.nowcoder.com/questionTerminal/947f6eb80d944a84850b0538bf0ec3a5  大北砸
	
*/


import java.util.*;
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
    /**
    Convert函数的功能：将一个二叉搜索树转换成有序的双向链表，返回链表的头结点
    pLast：当前链表的末尾节点
    
    递归过程：将整个树分解成了无数的小树，然后将他们分别转化成了一小段一小段的双向链表。
    再利用pLast记录总的链表的末尾，然后将这些小段链表一个接一个地加到末尾。
    */
    
    //pLast记录当前链表的末尾节点
    TreeNode pLast = null;
    public TreeNode Convert(TreeNode root) {
        //二叉搜索树的中序是顺序的
        if(root == null)
          return null;
        
        //如果左子树为空，那么根结点root为双向链表的头结点
        TreeNode head = Convert(root.left);
        if(head == null)
            head = root;
        
        //连接当前结点root和当前链表的尾结点
        root.left = pLast;
        if(pLast != null)
           pLast.right = root;
        pLast = root;
        
        Convert(root.right);
        
        return head;
    }
}