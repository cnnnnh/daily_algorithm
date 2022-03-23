/*
 * INF 범위 잘 살피기!
 */
import java.io.*;
import java.util.*;

public class Main {
	static int v;
	static final int INF = 100000000;
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
		
		list = new ArrayList[v+1];
		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}
		distance = new int[v+1];
		visited = new boolean[v+1];
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, cost));
			list[to].add(new Node(from, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int result1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, v);
		int result2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, v);
		int result = Math.min(result1, result2);
		
		bw.append(result >= INF ? "-1" : String.valueOf(result));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static int dijkstra (int start, int end) {
		pq = new PriorityQueue<>();
		
		Arrays.fill(visited, false);
		Arrays.fill(distance, INF);
		distance[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (visited[cur.vertex]) continue;
			visited[cur.vertex] = true;
			
			if (cur.vertex == end) break;
			
			for (Node node : list[cur.vertex]) {
				if (distance[node.vertex] > distance[cur.vertex] + node.cost) {
					distance[node.vertex] = distance[cur.vertex] + node.cost;
					pq.offer(new Node(node.vertex, distance[node.vertex]));
				}
			}
		}
		
		return distance[end];
		
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