import java.io.*;
import java.util.*;

public class Main {
	
	static int r, c;
	static char[][] map;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		map = new char[r][c];
		Queue<Point> q = new LinkedList<>();
		
		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') q.offer(new Point(i, j, 0));
			}
		}
		
		int time = 0;
		boolean flag = false;
		
		label:
		while(!q.isEmpty()) {
			Point p = q.poll();

			if (time < p.time) {
				time = p.time;
				spread();
			}

			if (map[p.x][p.y] == '*') continue;
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
					if (map[nx][ny] != 'X' && map[nx][ny] != '*' && map[nx][ny] != 'S') {
						if (map[nx][ny] == 'D') {
							time = p.time + 1;
							flag = true;
							break label;
						}
						map[nx][ny] = 'S';
						q.offer(new Point(nx, ny, p.time+1));
					}
				}
			}
		}
		
		bw.append(flag ? String.valueOf(time) : "KAKTUS");
		bw.flush();
		br.close();
		bw.close();
	}
	
	public static void spread() {
		char[][] temp = new char[r][c];
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				temp[i][j] = map[i][j];
			}
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == '*') {
					for (int k = 0; k < 4; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						if (x >= 0 && x < r && y >= 0 && y < c) {
							if (temp[x][y] != '*' && map[x][y] != 'D' && map[x][y] != 'X') {
								temp[x][y] = '*';
							}
						}
					}
				}
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}
	
	static class Point {
		int x, y, time;
		
		public Point (int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

}