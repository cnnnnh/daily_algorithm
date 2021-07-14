/*
 * 프림 알고리즘 사용
 * 크루스칼 알고리즘으로도 풀어보기!
 */
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		ArrayList<Node>[] list = new ArrayList[v+1];
		for (int i = 1; i <= v; i++) {
			list[i] = new ArrayList<>();
		}
		int[] distance = new int[v+1];
		boolean[] visited = new boolean[v+1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, cost));
			list[to].add(new Node(from, cost));
		}

		int result = 0;
		pq.offer(new Node(1, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (visited[cur.vertex]) continue;
			visited[cur.vertex] = true;
			result += cur.cost;
			
			for (Node n : list[cur.vertex]) {
				if (visited[n.vertex]) continue;
				pq.offer(n);
			}
			
		}
		
		bw.append(String.valueOf(result));
		bw.flush();
		br.close();
		bw.close();
		
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