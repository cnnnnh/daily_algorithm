import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> s = new Stack<>();
        
        String str = br.readLine();
        char pre = ' ';
        int n = 0;
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                s.push(c);
                n++;
            }
            else {
                n--;
                s.pop();
                if (pre == '(') {
                    result += n;
                }
                else {
                	result++;
                }
            }
            pre = c;
        }
        bw.append(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}