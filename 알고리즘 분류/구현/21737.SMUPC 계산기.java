import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Queue<String> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        
        for (int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            if (x >= '0' && x <= '9') {
                sb.append(x);
            }
            else {
                switch(x) {
                    case 'S' :
                        q.offer(sb.toString());
                        q.offer("-");
                        sb = new StringBuilder();
                        break;
                    case 'M' :
                        q.offer(sb.toString());
                        q.offer("*");
                        sb = new StringBuilder();
                        break;
                    case 'U' :
                        q.offer(sb.toString());
                        q.offer("/");
                        sb = new StringBuilder();
                        break;
                    case 'P' :
                        q.offer(sb.toString());
                        q.offer("+");
                        sb = new StringBuilder();
                        break;
                    case 'C' :
                        q.offer(sb.toString());
                        q.offer("C");
                        sb = new StringBuilder();
                        break;
                }
            }

        }
        int left = Integer.parseInt(q.poll());
        int right = 0;
        boolean flag = false;
        while(!q.isEmpty()) {
            switch(q.poll()) {
                case "-" :
                	if (q.isEmpty()) break;
                    right = Integer.parseInt(q.poll());
                    left -= right;
                    break;
                case "+" :
                	if (q.isEmpty()) break;
                    right = Integer.parseInt(q.poll());
                    left += right;
                    break;
                case "/" :
                	if (q.isEmpty()) break;
                    right = Integer.parseInt(q.poll());
                    left /= right;
                    break;
                case "*" :
                	if (q.isEmpty()) break;
                    right = Integer.parseInt(q.poll());
                    left *= right;
                    break;
                case "C" :
                    flag = true;
                    bw.append(String.valueOf(left) + " ");
                    break;
            }
        }
        
        if (!flag) {
            bw.append("NO OUTPUT");
        }
        bw.flush();
        br.close();
        bw.close();
        
    }
}