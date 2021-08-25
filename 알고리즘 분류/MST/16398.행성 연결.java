/*
 * result가 21억이 넘을 것 같은지?
 * -> 그러면 long으로 선언해주기
 */
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+1][n+1];
		int[] minEdge = new int[n+1];
		boolean[] visited = new boolean[n+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		pq.offer(new Edge(1, 0));
		
		long result = 0;
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if (visited[cur.vertex]) continue;
			visited[cur.vertex] = true;
			result += cur.cost;
			
			if (++cnt == n) break;
			
			for (int i = 1; i <= n; i++) {
				if (!visited[i]
						&& map[cur.vertex][i] != 0
						&& minEdge[i] > map[cur.vertex][i]) {
					minEdge[i] = map[cur.vertex][i];
					pq.offer(new Edge(i, minEdge[i]));
				}
			}
			
		}
		
		bw.append(String.valueOf(result));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	static class Edge implements Comparable<Edge> {
		int vertex;
		int cost;
		
		public Edge (int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}
		
		@Override
		public int compareTo (Edge e) {
			return Integer.compare(this.cost, e.cost);
		}
		
	}

}