import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }
        
        for (int i = 0; i < m; i++) {
            long x = pq.poll();
            long y = pq.poll();
            pq.offer(x+y);
            pq.offer(x+y);
        }
        
        long result = 0;
        while(!pq.isEmpty()) {
            result += pq.poll();
        }
        
        bw.append(String.valueOf(result));
        br.close();
        bw.close();
        
    }
}