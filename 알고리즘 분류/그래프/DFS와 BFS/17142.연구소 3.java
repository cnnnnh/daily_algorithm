/*
 * visited 배열을 사용해서 푸는 것이 더 효율적일듯...
 * 멋있는 척 하지 말자... 객기 부리지 말자..... ^-^
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n, m, emptySpace, answer;
	static int[] selected;
	static int[][] map, temp;
	static boolean flag;
	static ArrayList<Virus> list;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		emptySpace = 0;
		flag = false;
		
		map = new int[n][n];
		list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) emptySpace++;
				else if (map[i][j] == 2) list.add(new Virus(i, j));
			}
		}
		
		if (emptySpace == 0) {
			bw.append("0");
		}
		else {
			selected = new int[m];
			answer = -1;
			combination(0, 0);
			bw.append(String.valueOf(answer));
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static void combination(int cnt, int start) {
		if (cnt == m) {
			int result = spread(selected);
			if (result != -1) {
				if (answer != -1) answer = Math.min(answer, result);
				else answer = result;
			}
			return;
		}
		
		for (int i = start; i < list.size(); i++) {
			selected[cnt] = i;
			combination(cnt+1, i+1);
		}
	}
	
	private static void copy() {
		temp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) temp[i][j] = -1;
				else if (map[i][j] == 2) temp[i][j] = 1;
				else temp[i][j] = map[i][j];
			}
		}
	}
	
	private static int spread(int[] virusArr) {
		copy();
		Queue<Virus> q = new LinkedList<>();
		for (int i = 0; i < virusArr.length; i++) {
			int j = virusArr[i];
			q.offer(new Virus(list.get(j).x, list.get(j).y));
			temp[list.get(j).x][list.get(j).y] = 2;
		}
		
		int time = 0;
		int cnt = emptySpace;
		while(!q.isEmpty()) {
			Virus v = q.poll();
			
			if (cnt == 0) break;
			
			for (int i = 0; i < 4; i++) {
				int nx = v.x + dx[i];
				int ny = v.y + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
					if (temp[nx][ny] == -1 || temp[nx][ny] >= 2) continue;
					else if (temp[nx][ny] == 0) cnt--;
					temp[nx][ny] = temp[v.x][v.y] + 1;
					q.offer(new Virus(nx, ny));
					time = temp[nx][ny];
				}
			}
		}
		
		if (cnt == 0) return time - 2;
		else return -1;
		
	}
	
	static class Virus {
		int x;
		int y;
		
		public Virus (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}