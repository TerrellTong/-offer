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
				//出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边
				//还是右边，因此只好一个个试
                right = right-1;
            else
                //不能随便排除right，因为有可能mid就是right！！
				/*
				注意这里有个坑：如果待查询的范围最后只剩两个数，那么mid 一定会指向下标靠前的数字
				比如 array = [4,6]
				array[low] = 4 ;array[mid] = 4 ; array[high] = 6 ;
				如果high = mid - 1，就会产生错误， 因此high = mid
				但情形(1)中low = mid + 1就不会错误
				*/
                right = mid;
        }
        return array[left];
    }
}