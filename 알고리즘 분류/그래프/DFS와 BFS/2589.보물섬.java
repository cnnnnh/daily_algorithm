import java.io.*;
import java.util.*;

public class Main {

	static int n, m;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int result = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'L') {
					visited = new boolean[n][m];
					int num = bfs(i, j, 0);
					result = Math.max(result, num);
				}
			}
		}

		bw.append(String.valueOf(result));
		bw.flush();
		br.close();
		bw.close();
	}

	private static int bfs(int x, int y, int cnt) {
		Queue<Edge> q = new LinkedList<>();
		q.offer(new Edge(x, y, cnt));
		int result = 0;

		while (!q.isEmpty()) {
			Edge e = q.poll();

			if (visited[e.x][e.y]) continue;
			visited[e.x][e.y] = true;

			for (int i = 0; i < 4; i++) {
				int nx = e.x + dx[i];
				int ny = e.y + dy[i];

				if (isIn(nx, ny) && map[nx][ny] == 'L' && !visited[nx][ny]) {
					q.offer(new Edge(nx, ny, e.cnt + 1));
					result = Math.max(result, e.cnt + 1);
				}
			}
		}

		return result;

	}

	private static boolean isIn(int x, int y) {
		if (x >= 0 && x < n && y >= 0 && y < m) return true;
		return false;
	}

	static class Edge {
		int x;
		int y;
		int cnt;

		public Edge(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

	}

}