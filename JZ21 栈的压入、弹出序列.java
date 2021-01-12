/*
	算法思想：
		按照剑指offer的书中的思想实现的，放置一个辅助栈！
*/



import java.util.*;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack();
        int index = 0;
        int i=0;
        while(index < popA.length){
            int cur = popA[index];
            for(;i<pushA.length;i++){
				//如果当前栈为空，或者栈顶元素小于要弹出的原始，则入栈！
                if(stack.isEmpty() ||stack.peek() < cur){
                   stack.push(pushA[i]);
                }
            }
			//如果栈顶元素等于要弹出的元素，则出栈！
            if(cur == stack.peek()){
                stack.pop();
            }
            index++;
        }
        return stack.isEmpty();
    }
}