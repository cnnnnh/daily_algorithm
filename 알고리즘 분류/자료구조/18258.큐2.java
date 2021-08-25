import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        int x = 0;
        String str = null;
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();
            
            if (str.equals("push")) {
                x = Integer.parseInt(st.nextToken());
                q.offer(x);
            }
            else if (str.equals("pop")) {
                bw.append(q.isEmpty() ? "-1" : String.valueOf(q.poll()));
                bw.newLine();
            }
            else if (str.equals("size")) {
                bw.append(String.valueOf(q.size()));
                bw.newLine();
            }
            else if (str.equals("empty")) {
                bw.append(q.isEmpty() ? "1" : "0");
                bw.newLine();
            }
            else if (str.equals("front")) {
                bw.append(q.isEmpty() ? "-1" : String.valueOf(q.peek()));
                bw.newLine();
            }
            else if (str.equals("back")) {
                bw.append(q.isEmpty() ? "-1" : String.valueOf(q.peekLast()));
                bw.newLine();
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}