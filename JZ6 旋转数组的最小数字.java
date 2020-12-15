/*
	算法思想：
		之前做过，相当于二刷，不会！！！！！
		这里要比较的是mid和right！！
题解：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/er-fen-jian-zhi-si-xiang-fen-zhi-si-xiang-by-liwei/
https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/solution/labuladong-er-fen-fa-mo-ban-shi-xiao-liao-ma-by-41/
*/


import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0)
             return 0;
        int left = 0;
        int right = array.length-1;
        while(left <= right){
            int mid= (left+right) >>> 1;
            
            //如果比较mid和left，只能说明是递增，但是如果最小值就是left呢？怎么判断？
            //最右边比mid小，说明最小值一定在右边，发生了混乱
            if(array[right] < array[mid])
                 left = mid+1;
            else if(array[mid] == array[right])
                //此时把right排除掉
                right = right-1;
            else
                //不能随便排除right，因为有可能mid就是right！！
                right = mid;
        }
        return array[left];
    }
}