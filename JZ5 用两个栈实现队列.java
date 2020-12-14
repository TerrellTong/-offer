/*
	算法思想：
		之前做过，没有按照之前的思路，自己想了一个，每次入队都要把stack2的元素全放入stack1（浪费！！）
		优化；只要stack2不为空，则说明pop一定为队头元素，如果2号栈为空，则把一号栈的元素全部弹入到二号栈
		
*/


//自己的答案
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        while(!stack2.isEmpty())
            stack1.push(stack2.pop());
        stack1.push(node);
    }
    
    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}


//优化后
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
        //如果2号栈为空，则把一号栈的元素全部弹入到二号栈
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){                
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}