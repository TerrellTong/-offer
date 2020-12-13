/*
	算法思想：
		直接用一个StringBuilder即可
*/

public class Solution {
    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        while(index < s.length()){
            if(s.charAt(index) == ' '){
                sb.append("%20");
            }else
                sb.append(s.charAt(index));
            index++;
        }
        return sb.toString();
    }
}
