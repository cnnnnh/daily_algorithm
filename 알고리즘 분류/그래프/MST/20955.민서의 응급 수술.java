/*
 * union - find 의 의미를 제대로 알게 된 문제
 * 나 진짜... 천재가 아닐까? ^-^
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
		parents = new int[n+1];
		make();
		
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (!union(a, b)) cnt++;
		}
		
		for (int i = 1; i <= n; i++) {
			find(i);
		}
		
		Arrays.sort(parents);
		
		int x = parents[1];
		for (int i = 2; i <= n; i++) {
			if (x != parents[i]) {
				cnt++;
				x = parents[i];
			}
		}
		
		bw.append(String.valueOf(cnt));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static void make() {
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

}