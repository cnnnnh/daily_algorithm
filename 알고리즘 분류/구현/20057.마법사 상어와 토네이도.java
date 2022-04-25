import java.util.*;
import java.io.*;

/*
 * 1. 규칙을 못 찾겠으면 빠르게 노동을 하자
 * -> 정.확.하.게.^^
 * 2. 끝나는 시점 정확히 파악하기
 */

public class Main {
	
	static int N, answer;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {-1, 0, 1, 0};
	static ArrayList<Point>[] list;
	
    public static void main (String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][N];
		
		list = new ArrayList[4];
		for(int i = 0; i < 4; i++) {
			list[i] = new ArrayList<>();
		}
		
		addDir();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = 0;
		int x = N/2, y = N/2, nx = 0, ny = 0, px = 0, py = 0;
		int sand = 0, total = 0, cnt = 0, n = 1, dir = 0;
		while(true) {
			// 좌표 이동
			x += dx[dir];
			y += dy[dir];
			// 모래가 옮겨질 좌표
			nx = x + dx[dir];
			ny = y + dy[dir];
			// 해당 방향으로 이동한 횟수
			cnt++;
			
			if(board[x][y] != 0) {
				// 이동한 모래의 값
				total = 0;
				for(Point p : list[dir]) {
					// 비율이 있는 칸
					px = x + p.x;
					py = y + p.y;
					sand = board[x][y] * p.val / 100;
					// 배열 안일 때는 쌓임
					if(isIn(px, py)) {
						board[px][py] += sand;
					}
					// 배열 밖일 때는 answer에 더해줌
					else {
						answer += sand;
					}
					total += sand;
				}
				// 모래가 이동할 곳이 배열 안일 때는 쌓임
				if(isIn(nx, ny)) {
					board[nx][ny] += (board[x][y] - total);
				}
				// 배열 밖일 때는 answer에 더해줌
				else {
					answer += (board[x][y] - total);
				}
				// 초기화
				board[x][y] = 0;
				
			}

			// 방향 바꾸기
			if(cnt == n) {
				cnt = 0;
				if(dir % 2 != 0) {
					dir = (dir+2) % 4 - 1;
					n++;
				}
				else {
					dir++;
				}
			}
			
			// 마지막 지점에 오면 소멸
			if(x == 0 && y == 0) break;
			
		}
		
		System.out.println(answer);
		
    }
    
    public static void addDir() {
    	list[0].add(new Point(-1, 1, 1));
    	list[0].add(new Point(1, 1, 1));
    	list[0].add(new Point(-2, 0, 2));
    	list[0].add(new Point(2, 0, 2));
    	list[0].add(new Point(0, -2, 5));
    	list[0].add(new Point(-1, 0, 7));
    	list[0].add(new Point(1, 0, 7));
    	list[0].add(new Point(-1, -1, 10));
    	list[0].add(new Point(1, -1, 10));
    	
    	list[1].add(new Point(-1, -1, 1));
    	list[1].add(new Point(-1, 1, 1));
    	list[1].add(new Point(0, -2, 2));
    	list[1].add(new Point(0, 2, 2));
    	list[1].add(new Point(2, 0, 5));
    	list[1].add(new Point(0, -1, 7));
    	list[1].add(new Point(0, 1, 7));
    	list[1].add(new Point(1, -1, 10));
    	list[1].add(new Point(1, 1, 10));
    	

    	list[2].add(new Point(-1, -1, 1));
    	list[2].add(new Point(1, -1, 1));
    	list[2].add(new Point(-2, 0, 2));
    	list[2].add(new Point(2, 0, 2));
    	list[2].add(new Point(0, 2, 5));
    	list[2].add(new Point(-1, 0, 7));
    	list[2].add(new Point(1, 0, 7));
    	list[2].add(new Point(-1, 1, 10));
    	list[2].add(new Point(1, 1, 10));
    	
    	list[3].add(new Point(1, -1, 1));
    	list[3].add(new Point(1, 1, 1));
    	list[3].add(new Point(0, -2, 2));
    	list[3].add(new Point(0, 2, 2));
    	list[3].add(new Point(-2, 0, 5));
    	list[3].add(new Point(0, -1, 7));
    	list[3].add(new Point(0, 1, 7));
    	list[3].add(new Point(-1, -1, 10));
    	list[3].add(new Point(-1, 1, 10));
    }
    
    public static boolean isIn(int x, int y) {
    	if(x < 0 || x >= N || y < 0 || y >= N) return false;
    	return true;
    }
    
    static class Point{
    	int x, y, val;
    	
    	public Point(int x, int y, int val) {
    		this.x = x;
    		this.y = y;
    		this.val = val;
    	}
    }
    
}
