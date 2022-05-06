import java.util.*;

/*
 * ���� Ǭ ����̶� ������ ������
 * ��Ȯ��: 30/30
 * ȿ����: 49/70
 * �հ�: 79/100 �� ä�� ����� ����� ��_��
 * �ð� �ʰ��� �� ���� �˾�����... ��¥ ���� �ʹ� ����� ����
 */

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> pre = new Stack<>();
        Stack<Integer> post = new Stack<>();
        Stack<Integer> del = new Stack<>();
        
        for(int i = 0; i <= k; i++) pre.push(i);
        for(int i = n-1; i > k; i--) post.push(i);
        
        int cnt = 0;
        for(int i = 0; i < cmd.length; i++) {
            char c = cmd[i].charAt(0);
            switch(c) {
                case 'U':
                    cnt = Integer.parseInt(cmd[i].substring(2));
                    while(cnt-- > 0) post.push(pre.pop());
                    break;
                case 'D':
                    cnt = Integer.parseInt(cmd[i].substring(2));
                    while(cnt-- > 0) pre.push(post.pop());
                    break;
                case 'C':
                    del.push(pre.pop());
                    if(!post.isEmpty()) pre.push(post.pop());
                    break;
                case 'Z':
                    Stack<Integer> s = new Stack<>();
                    int d = del.pop();
                    if(pre.isEmpty() && post.isEmpty()) pre.push(d);
                    else if (!pre.isEmpty() && pre.peek() > d) {
                        while(!pre.isEmpty() && pre.peek() > d) s.push(pre.pop());
                        pre.push(d);
                        while(!s.isEmpty()) pre.push(s.pop());
                    }
                    else if (!post.isEmpty() && post.peek() < d) {
                        while(!post.isEmpty() && post.peek() < d) s.push(post.pop());
                        post.push(d);
                        while(!s.isEmpty()) post.push(s.pop());
                    }
                    else post.push(d);
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("O".repeat(n));
        while(!del.isEmpty()) sb.setCharAt(del.pop(), 'X');
        
        return sb.toString();
    }
}