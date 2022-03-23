import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			if (m == 0 && n == 0) break;
			
			boolean[] visited = new boolean[m];
			ArrayList<Node>[] list = new ArrayList[m];
			
			for (int i = 0; i < m; i++) {
				list[i] = new ArrayList<>();
			}
			
			int total = 0;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				
				list[from].add(new Node(to, cost));
				list[to].add(new Node(from, cost));
				
				total += cost;
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(1, 0));
			
			int result = 0;
			
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				
				if (visited[cur.v]) continue;
				visited[cur.v] = true;
				result += cur.cost;
				
				for (Node node : list[cur.v]) {
					if (visited[node.v]) continue;
					pq.offer(node);
				}
				
			}
			
			bw.append(String.valueOf(total - result));
            bw.newLine();
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	static class Node implements Comparable<Node> {
		int v;
		int cost;
		
		public Node (int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
		
		@Override
		public int compareTo (Node n) {
			return this.cost - n.cost;
		}
		
	}


}