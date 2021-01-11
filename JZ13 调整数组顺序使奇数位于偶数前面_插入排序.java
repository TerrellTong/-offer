/*
	算法思想：
		采用插入排序，当前数是奇数，就往前找，遇到偶数就往它前面插

题解：https://www.nowcoder.com/questionTerminal/beb5aa231adc45b2a5dcc5b62c93f593 zgljl2012 
*/



public class Solution {
    public void reOrderArray(int [] array) {
        for(int i=1;i<array.length;i++){
            int tmp = array[i];
            //如果当前是奇数，则进行判断，判断之前的是否有偶数，如果有偶数，则将其交换到前面！
            if(tmp % 2 == 1){
                for(int j = i;j>0;j--){
                    if(array[j-1] % 2 == 0){
                        int t = array[j];
                        array[j] = array[j-1];
                        array[j-1] = t;
                    }
                }
            }
        }
    }
}