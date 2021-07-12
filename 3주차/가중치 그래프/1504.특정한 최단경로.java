import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[] distance;
	static boolean[] visited;
	static PriorityQueue<Node> q;
	static ArrayList<Node> list[];
	static int INF = 100000000;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		q = new PriorityQueue<>();
		distance = new int [N+1];
	
		int result1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
		int result2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);
		int result = Math.min(result1, result2);
		
		System.out.println(result>=INF ? -1 : result);
		
	}
	
	private static int dijkstra(int start, int end) {
		visited = new boolean[N+1];
		Arrays.fill(distance, INF);
		Arrays.fill(visited, false);
		distance[start] = 0;
		q.offer(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if (visited[cur.v]) continue;
			visited[cur.v] = true;
			
			if (cur.v == end) break;
			
			for(Node n : list[cur.v]) {
				if (distance[n.v] > distance[cur.v] + n.cost) {
					distance[n.v] = distance[cur.v] + n.cost;
					q.offer(new Node(n.v, distance[n.v]));
				}
			}
		}
		
		return distance[end];
	}
	
	private static class Node implements Comparable<Node> {
		int v;
		int cost;
		
		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
    
}
