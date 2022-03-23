package main;

import java.io.*;
import java.util.*;

public class Main {
	
	static int n, size, feed, answer;
	static Fish shark;
	static ArrayList<Fish> list;
	static Queue<Fish> q;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		size = 2;
		feed = 0;
		answer = 0;
		shark = null;
		list = new ArrayList<>();
		map = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Fish(i, j, 0);
					map[i][j] = 0;
				}
			}
		}

		simulate();
		System.out.println(answer);
	}
	
	private static void simulate() {
		
		while(true) {
			q = new LinkedList<>();
			q.offer(shark);
			visited = new boolean[n][n];
			visited[shark.x][shark.y] = true;
			
			while(!q.isEmpty()) {
				Fish f = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx = f.x + dx[i];
					int ny = f.y + dy[i];

					// 범위, 방문 여부 체크
					if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) continue;
					
					// 물고기를 먹는 경우
					if (map[nx][ny] < size && map[nx][ny] != 0) {
						visited[nx][ny] = true;
						q.add(new Fish(nx, ny, f.time+1));
						list.add(new Fish(nx, ny, f.time+1));
					}
					
					// 지나가는 경우 (아기상어와 같은 크기의 물고기, 빈 칸)
					if (map[nx][ny] == size || map[nx][ny] == 0) {
						visited[nx][ny] = true;
						q.add(new Fish(nx, ny, f.time+1));
					}
				}
			}
			
			if (!list.isEmpty()) {
				eat();
				q.clear();
			}
			else return;
		}
	}
	
	private static void eat() {
		Collections.sort(list);
		
		Fish f = list.get(0);
		answer += f.time;
		
		if (++feed == size) {
			feed = 0;
			size++;
		}
		
		// 아기상어 좌표 초기화
		shark.setX(f.x);
		shark.setY(f.y);
		map[f.x][f.y] = 0;
		
		list.clear();
	}
	
	static class Fish implements Comparable<Fish> {
		int x;
		int y;
		int time;
		
		public Fish (int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
		
		public void setX (int x) {
			this.x = x;
		}
		
		public void setY (int y) {
			this.y = y;
		}
	
		@Override
		public int compareTo(Fish f) {
			if (f.time == this.time) {
				if (f.x == this.x) {
					return this.y - f.y;
				}
				return this.x - f.x;
			}
			return this.time - f.time;
		}
	}

}
