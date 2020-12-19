/*
	算法思想：
		我自己做是用的Integer.toBinaryString()，直接获得String字符串。
		
		此题本质为位运算，我们通过让n与1进行 & 运算，如果不为0，说明这个位是1，然后将1左移，即可得到我们想要的结果！
*/

public class Solution {
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if((flag & n) != 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }
}

//自己的方法
public class Solution {
    public int NumberOf1(int n) {
        String str = Integer.toBinaryString(n);
        int count = 0;
        for(char c:str.toCharArray()){
            if(c == '1')
                count++;
        }
        return count;
    }
}