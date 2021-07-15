/*
 * 좀 천재같았다 ^-^
 * union - find 잘 알아두기!
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
		int m = Integer.parseInt(st.nextToken());
		
		parents = new int[n];
		make();
		
		int answer = 0;
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (find(a) != find(b)) {
				union(a, b);
			}
			else {
				answer = i;
				break;
			}
		}
		
		bw.append(String.valueOf(answer));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static void make() {
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}
	
	private static int find (int a) {
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

}