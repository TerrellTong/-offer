/*
	算法思想：
		我自己做是用的一个一个乘
		
		指数优化，如果当前n为偶数，则n次方为 n/2的平方， 如果n是奇数，则为a^n = a^[(n-1)/2] * a^[(n-1)/2] * a
*/

//对于指数优化的思想！！ 剑指offer132
public class Solution {
    public double Power(double base, int exponent) {
        int n = Math.abs(exponent);
        if(exponent == 0)
            return 1;
        if(exponent == 1)
            return base;
        //计算当前值一半的指数
        double res = Power(base,n >>> 1);
        //对当前一半的指数再*2,就为当前要求的指数了
        res *= res;
		//如果是奇数的话，二进制的最后一位一定是1，那么1和1相与，一定为1，侧面说明了该数是奇数！
        if((n & 1) == 1)
            res *= base;
        if(exponent < 0)
            return 1/res;
        return res;
        
  }
}

//自己的方法，最笨蛋的方法！
public class Solution {
    public double Power(double base, int exponent) {
        if(exponent == 0)
            return 1;
        if(exponent == 1)
            return base;
        double res = base;

        if(exponent < 0){
            for(int i=2;i<=-exponent;i++)
                res *= base;
            double a= 1/res;
            return (double)(1/res);
        }else{
            for(int i=2;i<=exponent;i++)
                res *= base;
        }

        return res;
  }
}