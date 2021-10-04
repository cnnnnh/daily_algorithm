import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static boolean[][] visited;
	static char[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int normal = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					normal++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'R') map[i][j] = 'G';
			}
		}
		
		visited = new boolean[N][N];
		
		int abnormal = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					abnormal++;
				}
			}
		}
		
		bw.append(String.valueOf(normal) + " " + String.valueOf(abnormal));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	public static void dfs (int x, int y) {
		if(visited[x][y]) return;
		visited[x][y] = true;
		char c = map[x][y];
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (map[nx][ny] == c) {
					dfs(nx, ny);
				}
			}
		}
	}


}