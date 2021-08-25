import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[V+1];
		
		ArrayList<Node>[] list = new ArrayList[V+1];
		
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0 ; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, cost));
			list[to].add(new Node(from, cost));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1, 0));

		int result = 0;
		int last = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (visited[cur.v]) continue;
			visited[cur.v] = true;
			result += cur.cost;
			last = Math.max(cur.cost, last);
			
			for (Node n : list[cur.v]) {
				if (visited[n.v]) continue;
				pq.offer(n);
			}
			
		}
		
		bw.append(String.valueOf(result - last));
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