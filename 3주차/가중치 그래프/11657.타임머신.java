/*
 * 멋있는 INF 를 배웠다!
 * (int) 1e9 == 1000000000
 * 
 * distance의 값을 계속 더해주면 overflow 발생
 * -> distance 배열을 long 으로 선언해주기
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int INF = (int)1e9;
	static long[] dist;
	static ArrayList<Edge>[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		dist = new long[n+1];
		list = new ArrayList[n+1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		Arrays.fill(dist, INF);
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Edge(b, c));
		}
		
		if (bellmanFord()) {
			for (int i = 2; i <= n; i++) {
				bw.append(dist[i] == INF ? "-1" : String.valueOf(dist[i]));
				bw.newLine();
			}
		}
		else {
			bw.append("-1");
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static boolean bellmanFord() {
		dist[1] = 0;
		boolean flag = false;
		
		for (int i = 1; i < n; i++) {
			flag = false;
			for (int j = 1; j <= n; j++) {
				for (Edge e : list[j]) {
					if (dist[j] == INF) break;
					if (dist[e.to] > dist[j] + e.cost) {
						dist[e.to] = dist[j] + e.cost;
						flag = true;
					}
				}
			}
			if (!flag) break;
		}
		
		if (flag) {
			for (int i = 1; i <= n; i++) {
				for (Edge e : list[i]) {
					if (dist[i] == INF) break;
					if (dist[e.to] > dist[i] + e.cost) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	static class Edge {
		int to;
		int cost;
		
		public Edge (int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

}