/*
	算法思想：
		简单的头插法
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
    public ListNode ReverseList(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        ListNode oldHead = dummyHead.next;
        while(head != null){
            ListNode tmp = head.next;
            head.next = null;
            dummyHead.next = head;
            head.next = oldHead;
            oldHead = head;
            head = tmp;
        }
        return dummyHead.next;
    }
}