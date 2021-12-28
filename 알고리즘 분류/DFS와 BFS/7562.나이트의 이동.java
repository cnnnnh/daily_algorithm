import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n, start_x, start_y, end_x, end_y, min;
		int tc = Integer.parseInt(st.nextToken());
		int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
		int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};
		boolean[][] visited;
		Queue<Point> q;
		
		for (int T = 0; T< tc; T++) {
			n = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			visited = new boolean[n][n];
			q = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			start_x = Integer.parseInt(st.nextToken());
			start_y = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			end_x = Integer.parseInt(st.nextToken());
			end_y = Integer.parseInt(st.nextToken());
			
			q.offer(new Point(start_x, start_y, 0));
			visited[start_x][start_y] = true;
			
			while(!q.isEmpty()) {
				Point cur = q.poll();
				if (cur.x == end_x && cur.y == end_y) {
					min = Math.min(cur.cnt, min);
					continue;
				}
				
				for (int i = 0; i < 8; i++) {
					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];
					
					if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny])
						continue;
					
					visited[nx][ny] = true;
					q.offer(new Point(nx, ny, cur.cnt + 1));
				}
			}
			
			bw.append(String.valueOf(min));
			bw.newLine();
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	static class Point {
		int x;
		int y;
		int cnt;
		
		public Point (int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}