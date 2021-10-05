import java.io.*;
import java.util.*;

public class Main {
	
	static int min;
	static boolean[][] board;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		min = 8 * 8;
		board = new boolean[n][m];
		String str;
		
		for (int i = 0; i < n; i++) {
			str = br.readLine();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == 'W') board[i][j] = true;
			}
		}
		
		for (int i = 0; i <= n-8; i++) {
			for (int j = 0; j <= m-8; j++) {
				min = Math.min(paint(i, j), min);
			}
		}
		
		bw.append(String.valueOf(min));
		bw.flush();
		br.close();
		bw.close();
	}

	public static int paint(int x, int y) {
		int cnt = 0;
		boolean flag = false;
		
		for (int i = x; i < x+8; i++) {
			for (int j = y; j < y+8; j++) {
				if (board[i][j] != flag) cnt++;
				flag = !flag;
			}
			flag = !flag;
		}
		
		return Math.min(cnt, 64 - cnt);
	}
	
}