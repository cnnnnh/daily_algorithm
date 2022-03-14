import java.io.*;
import java.util.*;

// 벽돌을 편하게 내리는 경이로운 방법을 발견하였다...
// 그것은 바로 stack 사용하기... ㄴ(ㅇ0ㅇ)ㄱ
// 알고리즘 고수님에게 배열로 옮기는 코드도 받았으니 공부할 것!

public class Solution {
	
	static int N, H, W, min;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[] number;
	static int[][] board, temp;
	static boolean[][] crushed;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int tc = Integer.parseInt(br.readLine().trim());
		
		for(int T = 1; T <= tc; T++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			min = Integer.MAX_VALUE;
			
			board = new int[H][W];
			number = new int[N];
			
			for(int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for(int j = 0; j < W; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			permutation(0);
			System.out.println("#" + T + " " + min);
			
		}
	}

	public static void permutation(int cnt) {
		if (cnt == N) {
			min = Math.min(min, crush(number));
			return;
		}
		
		for(int i = 0; i < W; i++) {
			number[cnt] = i;
			permutation(cnt+1);
		}
	}
	
	public static int crush(int[] arr) {
		int index = 0;
		int height = 0;
		
		temp = new int[H][W];
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				temp[i][j] = board[i][j];
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			crushed = new boolean[H][W];
			index = arr[i];
			height = 0;
			
			while(height != H) {
				if (temp[height][index] != 0) {
					check(height, index, temp[height][index]);
					delete();
					break;
				}
				else height++;
			}
		}
		
		return calculate(temp);
	}
	
	public static void check(int x, int y, int num) {
		int nx = x;
		int ny = y;
		crushed[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			for(int j = 1; j < num; j++) {
				nx = x + (dx[i] * j);
				ny = y + (dy[i] * j);
				if(nx < 0 || nx >= H ||ny < 0 || ny >= W) break;
				if(crushed[nx][ny]) continue;
				crushed[nx][ny] = true;
				check(nx, ny, temp[nx][ny]);
			}
		}
	}
	
	public static void delete() {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(crushed[i][j]) {
					// 벽돌 부수기
					temp[i][j] = 0;
				}
			}
		}
		
		compact();
	}
	
	public static void compact() {
		Stack<Integer> s = null;
		for(int i = 0; i < W; i++) {
			s = new Stack<>();
			for (int j = 0; j < H; j++) {
				if(temp[j][i] != 0) s.add(temp[j][i]);
			}
			for(int j = H-1; j >= 0; j--) {
				if(s.isEmpty()) temp[j][i] = 0;
				else temp[j][i] = s.pop();
			}
		}
	}
	
	public static int calculate(int[][] arr) {
		int result = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(arr[i][j] != 0) result++;
			}
		}
		
		return result;
	}
	
}
