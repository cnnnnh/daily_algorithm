import java.io.*;
import java.util.*;

public class Main {
	static int[][] cost, dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		cost = new int[n][3];
		dp = new int[n][3];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];
		
		bw.append(String.valueOf(Math.min(paint(n-1, 0), Math.min(paint(n-1, 1), paint(n-1, 2)))));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static int paint(int n, int color) {
		if (dp[n][color] == 0) {
			if (color == 0) {
				dp[n][color] = cost[n][color] + Math.min(paint(n-1, 1), paint(n-1, 2));
			}
			else if (color == 1) {
				dp[n][color] = cost[n][color] + Math.min(paint(n-1, 0), paint(n-1, 2));
			}
			else {
				dp[n][color] = cost[n][color] + Math.min(paint(n-1, 0), paint(n-1, 1));
			}
		}
		
		return dp[n][color];
	}
	
}