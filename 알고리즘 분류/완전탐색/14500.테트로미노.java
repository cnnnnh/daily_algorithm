import java.io.*;
import java.util.*;

public class Main {
	
	static int n, m, max;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	static int[][] map;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		max = Integer.MIN_VALUE;
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				check(i, j);
				visited[i][j] = false;
			}
		}
        
		System.out.println(max);
	}
	
	private static void dfs (int x, int y, int depth, int sum) {
		// Å½»öÇÑ Ä­ÀÌ 4Ä­ÀÌ µÇ¾úÀ» ¶§, ÃÖ´ñ°ª °»½Å
		if (depth == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;
			
			visited[nx][ny] = true;
			dfs(nx, ny, depth+1, sum+map[nx][ny]);
			visited[nx][ny] = false;
		}
		
	}
	
	// ¤¿, ¤Ã, ¤Ç, ¤Ì ¸ð¾ç Ã¼Å©
	private static void check (int x, int y) {
		int sum = 0;
		// ¤¿
		if (x-1 >= 0 && x+1 < n && y >= 0 && y+1 < m) {
			sum = map[x][y] + map[x-1][y] + map[x+1][y] + map[x][y+1];
			max = Math.max(max, sum);
		}
		// ¤Ã
		if (x-1 >= 0 && x+1 < n && y-1 >= 0 && y < m) {
			sum = map[x][y] + map[x-1][y] + map[x+1][y] + map[x][y-1];
			max = Math.max(max, sum);
		}
		// ¤Ç
		if (x-1 >= 0 && x < n && y-1 >= 0 && y+1 < m) {
			sum = map[x][y] + map[x-1][y] + map[x][y-1] + map[x][y+1];
			max = Math.max(max, sum);
		}
		// ¤Ì
		if (x >= 0 && x+1 < n && y-1 >= 0 && y+1 < m) {
			sum = map[x][y] + map[x][y-1] + map[x][y+1] + map[x+1][y];
			max = Math.max(max, sum);
		}
	}
	
}
