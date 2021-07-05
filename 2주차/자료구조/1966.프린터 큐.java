import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Node> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int TC = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
        	q = new LinkedList<>();
        	pq = new PriorityQueue<>(Collections.reverseOrder());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int order = Integer.parseInt(st.nextToken());
                q.offer(new Node(j, order));
                pq.offer(order);
            }
            
            while(!q.isEmpty()) {
                if (q.peek().order == pq.peek()) {
                    if (q.peek().index == m) {
                        break;
                    }
                    q.poll();
                    pq.poll();
                }
                else {
                    q.offer(q.poll());
                }
            }
            
            bw.append(String.valueOf(n - q.size() + 1));
            bw.newLine();
            
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    static class Node {
        int index;
        int order;
        
        public Node(int index, int order) {
			this.index = index;
			this.order = order;
		}
    }
}