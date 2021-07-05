import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> s = new Stack<>();
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            boolean flag = false;
            s = new Stack<>();
            
            for (int j = 0; j < str.length(); j++) {
                char x = str.charAt(j);
                if (x == '(') {
                    s.push("(");
                }
                else {
                    if (s.isEmpty()) {
                        flag = true;
                        break;
                    }
                    else {
                        s.pop();
                    }
                }
            }
            
            if (flag || !s.isEmpty()) {
                bw.append("NO");
            }
            else {
                bw.append("YES");
            }
            bw.newLine();
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
}