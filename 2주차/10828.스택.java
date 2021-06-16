import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> s = new Stack<>();
        int n = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            
            if (str.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                s.push(x);
            }
            else if (str.equals("pop")) {
                if (s.isEmpty()) {
                    bw.append("-1");
                    bw.newLine();
                }
                else {
                    bw.append(String.valueOf(s.pop()));
                    bw.newLine();
                }
            }
            else if (str.equals("size")) {
                bw.append(String.valueOf(s.size()));
                bw.newLine();
            }
            else if (str.equals("empty")) {
                if (s.isEmpty()) {
                    bw.append("1");
                    bw.newLine();
                }
                else {
                    bw.append("0");
                    bw.newLine();
                }
            }
            else if (str.equals("top")) {
                if (s.isEmpty()) {
                    bw.append("-1");
                    bw.newLine();
                }
                else {
                    bw.append(String.valueOf(s.peek()));
                    bw.newLine();
                }
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}