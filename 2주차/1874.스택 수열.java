import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> number = new Stack<>();
        Stack<Integer> s = new Stack<>();
        
        int n = Integer.parseInt(br.readLine());

        for (int i = n; i > 0; i--) {
            number.push(i);
        }
        
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            
            while(!number.isEmpty() && number.peek() <= x) {
                s.push(number.pop());
                sb.append("+\n");
                if (number.isEmpty()) break;
            }
            
            if (s.peek() == x) {
                s.pop();
                sb.append("-\n");
            }
            else {
            	sb = new StringBuilder();
                sb.append("NO\n");
                break;
            }
            
        }
        
        System.out.println(sb);
        br.close();
        
    }
}