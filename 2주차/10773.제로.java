import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> s = new Stack<>();
        
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                s.pop();
            }
            else {
                s.push(x);
            }
        }
        
        while(!s.isEmpty()) {
            result += s.pop();
        }
        
        bw.append(String.valueOf(result));
        bw.flush();
        br.close();
        bw.close();
    }
}