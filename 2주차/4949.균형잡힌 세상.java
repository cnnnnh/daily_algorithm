import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> s = null;
        boolean flag = false;
        String str = null;
        
        while(true) {
            str = br.readLine();
            if (str.equals(".")) break;
            
            s = new Stack<>();
            flag = false;
            
            for (int i = 0; i < str.length(); i++) {
                char x = str.charAt(i);
                if (x == '(' || x == '[') {
                    s.push(String.valueOf(x));
                }
                else if (x == ')') {
                    if (!s.isEmpty() && s.peek().equals("(")) {
                        s.pop();
                    }
                    else {
                        flag = true;
                        break;
                    }
                }
                else if (x == ']') {
                    if (!s.isEmpty() && s.peek().equals("[")) {
                        s.pop();
                    }
                    else {
                        flag = true;
                        break;
                    }
                }
            }
            
            if (flag || !s.isEmpty()) {
                bw.append("no");
            }
            else {
                bw.append("yes");
            }
            bw.newLine();
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
}