/*
	算法思想：
		链表复制，用map存储，LeetCode（字节跳动）之前做过！
*/



import java.util.*;
/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        //存储新旧节点的映射
        Map<RandomListNode,RandomListNode> map = new HashMap();
        RandomListNode cur = pHead;
        while(cur != null){
            RandomListNode newNode = new RandomListNode(cur.label);
            map.put(cur,newNode);
            cur = cur.next;
        }
        
        cur = pHead;
        while(cur != null){
            RandomListNode newNode = map.get(cur);
            newNode.next = map.get(cur.next);
            newNode.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }
}