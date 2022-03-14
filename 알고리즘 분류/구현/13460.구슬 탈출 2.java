package main;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int min = Integer.MAX_VALUE;
	static char[][] board;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][];
		Point blue = null;
		Point red = null;
		
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
			for(int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'B') blue = new Point(i, j, 0, false);
				else if (board[i][j] == 'R') red = new Point(i, j, 0, false);
			}
		}
		
		Queue<Point[]> q = new LinkedList<>();
		q.offer(new Point[] {red, blue});
		
		int n = 0;
		
		
		label:
		while(!q.isEmpty()) {
			n++;
			Point[] p = q.poll();
			Point[] temp = null;
			Point[] result = new Point[2];
			Point r = p[0];
			Point b = p[1];
			
			if(p[0].cnt >= 10) break;
			
			for (int i = 0; i < 4; i++) {
				switch(i) {
				// 상
				case 0:
					// 같은 선상일 때
					if (r.y == b.y) {
						// blue가 더 위에 있을 때
						if (r.x > b.x) {
							temp = roll(b, r, i);
							result = new Point[2];
							result[0] = temp[1];
							result[1] = temp[0];
							break;
						}
					}
					result = roll(r, b, i);
					break;
				// 하
				case 1:
					// 같은 선상일 때
					if (r.y == b.y) {
						// blue가 더 아래에 있을 때
						if (r.x < b.x) {
							temp = roll(b, r, i);
							result = new Point[2];
							result[0] = temp[1];
							result[1] = temp[0];
							break;
						}
					}
					result = roll(r, b, i);
					break;
				// 좌
				case 2:
					// 같은 선상일 때
					if (r.x == b.x) {
						// blue가 더 왼쪽에 있을 때
						if (r.y > b.y) {
							temp = roll(b, r, i);
							result = new Point[2];
							result[0] = temp[1];
							result[1] = temp[0];
							break;
						}
					}
					result = roll(r, b, i);
					break;
				// 우
				case 3:
					// 같은 선상일 때
					if (r.x == b.x) {
						// blue가 더 오른쪽에 있을 때
						if (r.y < b.y) {
							temp = roll(b, r, i);
							result = new Point[2];
							result[0] = temp[1];
							result[1] = temp[0];
							break;
						}
					}
					result = roll(r, b, i);
					break;
				default:
					break;
				}
				
				// 빨간 구슬만 나왔을 때
				if(result[0].out && !result[1].out) {
					min = Math.min(min, result[0].cnt);
					break label;
				}
				// 빨간/파란 구슬이 둘 다 안 나왔을 때
				if(!result[0].out && !result[1].out) {
					q.offer(result);
				}
			}
			
		}
		
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		
		
		
	}
	
	public static Point[] roll (Point p1, Point p2, int dir) {
		
		Point first = new Point(p1.x, p1.y, p1.cnt+1, false);
		Point second = new Point(p2.x, p2.y, p2.cnt+1, false);
		
		switch(dir) {
		// 상
		case 0:
			for(int i = first.x-1; i >= 0; i--) {
				if (board[i][first.y] == '#') break;
				else if (board[i][first.y] == 'O') first.out = true;
				first.x = i;
			}
			for(int i = second.x-1; i >= 0; i--) {
				if (board[i][second.y] == '#') break;
				else if (board[i][second.y] == 'O') second.out = true;
				if ((first.y == second.y) && (i == first.x)) {
					second.x = i+1;
					break;
				}
				second.x = i;
			}
			break;
		// 하
		case 1:
			for(int i = first.x+1; i < N; i++) {
				if (board[i][first.y] == '#') break;
				else if (board[i][first.y] == 'O') first.out = true;
				first.x = i;
			}
			for(int i = second.x+1; i < N; i++) {
				if (board[i][second.y] == '#') break;
				else if (board[i][second.y] == 'O') second.out = true;
				if ((first.y == second.y) && (i == first.x)) {
					second.x = i-1;
					break;
				}
				second.x = i;
			}
			break;
		// 좌
		case 2:
			for(int i = first.y-1; i >= 0; i--) {
				if (board[first.x][i] == '#') break;
				else if (board[first.x][i] == 'O') first.out = true;
				first.y = i;
			}
			for(int i = second.y-1; i >= 0; i--) {
				if (board[second.x][i] == '#') break;
				else if (board[second.x][i] == 'O') second.out = true;
				if ((first.x == second.x) && (i == first.y)) {
					second.y = i+1;
					break;
				}
				second.y = i;
			}
			break;
		// 우
		case 3:
			for(int i = first.y+1; i < M; i++) {
				if (board[first.x][i] == '#') break;
				else if (board[first.x][i] == 'O') first.out = true;
				first.y = i;
			}
			for(int i = second.y+1; i < M; i++) {
				if (board[second.x][i] == '#') break;
				else if (board[second.x][i] == 'O') second.out = true;
				if ((first.x == second.x) && (i == first.y)) {
					second.y = i-1;
					break;
				}
				second.y = i;
			}
			break;
		}
		
		return new Point[] {first, second};
	}
	
	static class Point {
		int x;
		int y;
		int cnt;
		boolean out;
		
		public Point(int x, int y, int cnt, boolean out) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.out = out;
		}
	}
	

}
