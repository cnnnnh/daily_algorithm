import java.io.*;
import java.util.*;

public class Main {
	static int v;
	static final int INF = 1000000000;
	static int[] cost;
	static boolean[] visited;
	static PriorityQueue<Node> pq;
	static ArrayList<Node>[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[v+1];
		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		
		pq = new PriorityQueue<>();
		cost = new int[v+1];
		visited = new boolean[v+1];
		
		if (dijkstra(1, p) + dijkstra(p, v) == dijkstra(1, v)) {
			bw.append("SAVE HIM");
		}
		else {
			bw.append("GOOD BYE");
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static int dijkstra (int start, int end) {
		Arrays.fill(cost, INF);
		Arrays.fill(visited, false);
		cost[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
				
			if (visited[cur.vertex]) continue;
			visited[cur.vertex] = true;
			
			if (cur.vertex == end) break;
			
			for (Node n : list[cur.vertex]) {
				if (cost[n.vertex] > cost[cur.vertex] + n.cost) {
					cost[n.vertex] = cost[cur.vertex] + n.cost;
					pq.offer(new Node(n.vertex, cost[n.vertex]));
				}
			}
			
		}
		
		return cost[end];
	}
	
	static class Node implements Comparable<Node> {
		int vertex;
		int cost;
		
		public Node (int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}
		
		@Override
		public int compareTo (Node n) {
			return this.cost - n.cost;
		}

    }
	
}