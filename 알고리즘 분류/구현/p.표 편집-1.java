import java.util.*;

/*
 * �㹫�ϴ�... �̷��� ���� Ǯ������ٴ�
 * �η��� �η���
 * õ��� ��¥...
 */

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> stack = new Stack<>();
        int len = n;
        
        for(int i = 0; i < cmd.length; i++) {
            char c = cmd[i].charAt(0);
            if(c == 'U') k -= Integer.parseInt(cmd[i].substring(2));
            else if (c == 'D') k += Integer.parseInt(cmd[i].substring(2));
            else if (c == 'C') {
                stack.push(k);
                len--;
                if(k == len) k--;
            }
            else {
                if(stack.pop() <= k) k++;
                len++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("O".repeat(len));
        while(!stack.isEmpty()) sb.insert(stack.pop(), "X");
        
        return sb.toString();
    }
}