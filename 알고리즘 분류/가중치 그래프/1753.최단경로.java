import java.io.*;
import java.util.*;

public class Main {
	static int v;
	static final int INF = 1000000000;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<Node>[] list;
	static PriorityQueue<Node> pq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(br.readLine());
		
		list = new ArrayList[v+1];
		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}
		distance = new int[v+1];
		visited = new boolean[v+1];
		pq = new PriorityQueue<>();
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, cost));
		}
		
		dijkstra(k);
		
		for (int i = 1; i <= v; i++) {
			bw.append(distance[i] == INF ? "INF" : String.valueOf(distance[i]));
			bw.newLine();
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static void dijkstra (int start) {
		Arrays.fill(visited, false);
		Arrays.fill(distance, INF);
		distance[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (visited[cur.vertex]) continue;
			visited[cur.vertex] = true;
			
			for (Node node : list[cur.vertex]) {
				if (distance[node.vertex] > distance[cur.vertex] + node.cost) {
					distance[node.vertex] = distance[cur.vertex] + node.cost;
					pq.offer(new Node(node.vertex, distance[node.vertex]));
				}
			}
		}
		
	}
	
	static class Node implements Comparable<Node> {
		int vertex;
		int cost;
		
		public Node (int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}
		
		@Override
		public int compareTo (Node o) {
			return this.cost - o.cost;
		}
		
	}
	

}