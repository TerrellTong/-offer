/*
	算法思想：
		最小栈的实现，之前做过挺多次了！！！
*/



import java.util.Stack;

public class Solution {

    Stack<Integer> data = new Stack();
    Stack<Integer> min = new Stack();
    public void push(int node) {
        if(min.isEmpty() || min.peek() >= node)
            min.push(node);
        data.push(node);
    }
    
    public void pop() {
        int cur = data.pop();
        if(cur == min.peek())
            min.pop();
        
    }
    
    public int top() {
        return data.peek();
    }
    
    public int min() {
        return min.peek();
    }
}