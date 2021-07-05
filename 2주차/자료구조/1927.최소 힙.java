import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                bw.append(pq.isEmpty() ? "0" : String.valueOf(pq.poll()));
                bw.newLine();
            }
            else {
                pq.offer(x);
            }
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}