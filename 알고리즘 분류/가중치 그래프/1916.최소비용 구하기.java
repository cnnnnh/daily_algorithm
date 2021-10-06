import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m;
	static final int INF = 1000000000;
	static int[] distance;
	static boolean[] visited;
	static ArrayList<Node>[] list;
	static PriorityQueue<Node> pq;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		distance = new int[n+1];
		visited = new boolean[n+1];
		list = new ArrayList[n+1];
		pq = new PriorityQueue<>();
		
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		dijkstra(start);
		
		bw.append(String.valueOf(distance[end]));
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void dijkstra (int start) {
		Arrays.fill(visited, false);
		Arrays.fill(distance, INF);
		distance[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (visited[cur.v]) continue;
			visited[cur.v] = true;
			
			for (Node node : list[cur.v]) {
				if (distance[node.v] > distance[cur.v] + node.cost) {
					distance[node.v] = distance[cur.v] + node.cost;
					pq.offer(new Node(node.v, distance[node.v]));
				}
			}
		}
		
	}
	
	static class Node implements Comparable<Node> {
		int v, cost;
		
		public Node (int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
		
	}
	
}