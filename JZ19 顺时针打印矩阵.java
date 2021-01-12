/*
	算法思想：
		螺旋矩阵，之前做过挺多次了！！！
*/



import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList();
        int top = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        while(true){
            for(int i=left;i<=right;i++)
                res.add(matrix[top][i]);
            if(++top > down)
                break;
            
            for(int i=top;i<=down;i++)
                res.add(matrix[i][right]);
            if(--right < left)
                break;
            
            for(int i=right;i>=left;i--)
                res.add(matrix[down][i]);
            if(--down < top)
                break;
            
            for(int i=down;i>=top;i--)
                res.add(matrix[i][left]);
            if(++left > right)
                break;
        }
        return res;
    }
}