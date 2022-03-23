import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		
		while(true) {
			if (count() >= 2) {
				bw.append(String.valueOf(time));
				break;
			}
			else if (count() == 0) {
				bw.append("0");
				break;
			}
			else {
				melt();
				time++;
			}
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	public static boolean isIn(int x, int y) {
		if (x >= 0 && x < n && y >= 0 && y < m) return true;
		return false;
	}
	
	public static void melt() {
		int[][] temp = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp[i][j] = map[i][j];
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(map[i][j] > 0) {
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if (isIn(nx, ny) && map[nx][ny] == 0) {
							temp[i][j]--;
						}
					}
				}
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = (temp[i][j] <= 0 ? 0 : temp[i][j]);
			}
		}
	}
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] != 0) {
				dfs(nx, ny);
			}
		}
	}
	
	public static int count() {
		visited = new boolean[n][m];
		int cnt = 0;
		
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && map[i][j] > 0) {
					dfs(i, j);
					cnt++;
				}
			}
		}
		return cnt;
	}
	
}