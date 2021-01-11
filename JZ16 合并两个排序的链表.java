/*
	算法思想：
		简单的合并
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
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }
        if(list1 != null)
            tail.next = list1;
        if(list2 != null)
            tail.next = list2;
         return dummyHead.next;
    }
}