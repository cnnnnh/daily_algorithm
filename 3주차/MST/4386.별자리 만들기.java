/*
 * 크루스칼 (union-find) 와 친해지기
 * Math.round 사용법 익히기
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] parents;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		parents = new int[n];
		
		Star[] starList = new Star[n];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			starList[i] = new Star(i, x, y);
		}
		
		for (int i = 0; i < n-1; i++) {
			for (int j = 1; j < n; j++) {
				if (i == j) continue;
				double cost = Math.sqrt(Math.pow(starList[i].x - starList[j].x, 2) +Math.pow(starList[i].y - starList[j].y, 2));
				pq.offer(new Edge(i, j, cost));
			}
		}
		
		make();
		
		double result = 0;
		int cnt = 0;
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			
			if (find(cur.from) != find(cur.to)) {
				union(cur.from, cur.to);
				result += cur.cost;
				if (++cnt == n-1) break;
			}
		}

		bw.append(String.valueOf(Math.round(result*100)/100.0));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static void make() {
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union (int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		double cost;
		
		public Edge (int from, int to, double cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo (Edge e) {
			return Double.compare(this.cost, e.cost);
		}
		
	}
	
	static class Star {
		int index;
		double x;
		double y;
		
		public Star (int index, double x, double y) {
			this.index = index;
			this.x = x;
			this.y = y;
		}
		
	}

}