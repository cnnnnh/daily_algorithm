package main;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, minLine, maxCore;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] board;
	static boolean[][] visited;
	static ArrayList<Core> list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int tc = Integer.parseInt(br.readLine().trim());
		
		for(int T = 1; T <= tc; T++) {
			N = Integer.parseInt(br.readLine().trim());
			board = new int[N][N];
			list = new ArrayList<>();
			minLine = Integer.MAX_VALUE;
			maxCore = Integer.MIN_VALUE;
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (i != 0 && i != N-1 && j != 0 && j != N-1) {
						if(board[i][j] == 1) list.add(new Core(i, j));
					}
				}
			}
			
			connect(0, 0, 0);
			System.out.println( "#" + T + " " +  minLine);
		}
	}

	public static void connect(int index, int core, int line) {
		if(index == list.size()) {
			if(core > maxCore) {
				maxCore = core;
				minLine = line;
			} else if (core == maxCore) {
				minLine = Math.min(minLine, line);
			}
			return;
		}
		
		int x = list.get(index).x;
		int y = list.get(index).y;
		
		for(int i = 0; i < 4; i++) {
			int cnt = 0;
			int nx = x;
			int ny = y;
			
			while(true) {
				nx += dx[i];
				ny += dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) break;
				
				if(board[nx][ny] == 1) {
					cnt = 0;
					break;
				}
				cnt++;
			}
			
			nx = x;
			ny = y;
			
			for(int j = 0; j < cnt; j++) {
				nx += dx[i];
				ny += dy[i];
				board[nx][ny] = 1;
			}
			
			if (cnt == 0) connect(index+1, core, line);
			else {
				connect(index+1, core+1, line+cnt);
				
				nx = x;
				ny = y;
				
				for(int j = 0; j < cnt; j++) {
					nx += dx[i];
					ny += dy[i];
					board[nx][ny] = 0;
				}
			}
		}
		
	}
	
	static class Core {
		int x;
		int y;
		
		public Core(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
