import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> q = new LinkedList<>();
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }
        
        while(q.size() > 1) {
            q.poll();
            if (q.size() == 1) {
                break;
            }
            q.offer(q.poll());
        }
        
        bw.append(String.valueOf(q.poll()));
        bw.flush();
        br.close();
        bw.close();
        
    }
}