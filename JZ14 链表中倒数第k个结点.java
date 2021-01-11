/*
	算法思想：
		简单的双指针
*/



/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null)
            return head;
        ListNode res = head;
        ListNode fast = head;
        int count = 1;
        while(count != k && fast != null){
            count++;
            fast = fast.next;
        }
        
        if(fast == null)
            return fast;
        
        while(fast.next != null){
            fast = fast.next;
            res = res.next;
        }
        return res;
    }
}