import java.io.*;
import java.util.*;

public class Main {
	
	static int N, MIN = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		combi(0, 0);
		bw.append(String.valueOf(MIN));
		bw.flush();
		br.close();
		bw.close();
	}

	private static void combi (int start, int cnt) {
		if (cnt == N/2) {
			cal();
			return;
		}
		
		for (int i = start; i < N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			combi(i+1, cnt+1);
			visited[i] = false;
		}
		
	}
	
	private static void cal () {
		int start = 0;
		int link = 0;
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) {
				for (int j = i+1; j < N; j++) {
					if (visited[j]) {
						start += map[i][j];
						start += map[j][i];
					}
				}
				
			}
			else {
				for (int j = i+1; j < N; j++) {
					if (!visited[j]) {
						link += map[i][j];
						link += map[j][i];
					}
				}
			}
		}
		
		MIN = Math.min(MIN, Math.abs(start - link));
		
	}

}