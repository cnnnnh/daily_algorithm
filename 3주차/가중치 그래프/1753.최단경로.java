import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine().trim());
		final int INFINITY = Integer.MAX_VALUE;
		
		// 정점 간 연결된 간선 정보 저장하기 위해 ArrayList 사용
		ArrayList<Node>[] list = new ArrayList[V+1];
		for (int i = 1; i <= V; i++) {
			// 정점 i와 인접한 다른 정점들 정보가 리스트에 저장됨
			list[i] = new ArrayList<Node>();
		}
		
		int[] distance = new int[V+1];	// 시작점 ~ 각 정점 최소비용
		Arrays.fill(distance, INFINITY);
		boolean[] visited = new boolean[V+1];
		
		// data input
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int v1 = Integer.parseInt(st.nextToken());		// from
			int v2 = Integer.parseInt(st.nextToken());		// to
			int weight = Integer.parseInt(st.nextToken());	// distance
			
			// v1 -> v2
			list[v1].add(new Node(v2, weight));
		}
		
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		distance[start] = 0; // 시작 정점 ~ start 까지의 최소비용
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			int num = q.poll().no; // 정점의 번호
			
			if (visited[num])
				continue;
			
			visited[num] = true;
			for (Node node : list[num]) {
				// distance[node.no] : ArrayList에서 꺼낸 노드 1개의 번호 기준 정점의 최소 비용
				// distance[num] : 시작 정점 ~ num번째 정점까지의 최소 비용
				// node.distance : 
				if (distance[node.no] > distance[num] + node.distance) {
					distance[node.no] = distance[num] + node.distance;
					q.add(new Node(node.no, distance[node.no]));
				}
			}
		}
		for (int i = 1; i <= V; i++) {
			if (distance[i] == INFINITY)
				System.out.println("INF");
			else
				System.out.println(distance[i]);
		}
		
	}
	
	private static class Node implements Comparable<Node>{
		int no;
		int distance;
		
		public Node(int vertex, int totalDistance) {
			this.no = vertex;
			this.distance = totalDistance;
		}

		@Override
		public int compareTo(Node o) {
			return this.distance-o.distance;
		}
	}

}