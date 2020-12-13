/*
	算法思想：
		我采用了一个栈的形式
*/

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode tmp = listNode;
        Stack<Integer> stack = new Stack();
        while(tmp != null){
            stack.push(tmp.val);
            tmp = tmp.next;
        }
        ArrayList<Integer> res = new ArrayList();
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    } 
}

//采用递归，参照别人的思路，自己重写了
public class Solution {
    public ArrayList<Integer> res = new ArrayList();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        dfs(listNode);
        return res;
    }
    
    public void dfs(ListNode p){
        if(p!=null){
            dfs(p.next);
            res.add(p.val);
        }
    }
}
