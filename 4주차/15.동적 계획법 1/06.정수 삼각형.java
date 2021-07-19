import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static Integer[][] cost, dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		cost = new Integer[n][n];
		dp = new Integer[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = cost[0][0];
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (dp[i][j] == null) {
					if (j-1 < 0) dp[i][j] = dp[i-1][j] + cost[i][j];
					else if (j == i) dp[i][j] = dp[i-1][j-1] + cost[i][j];
					else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + cost[i][j];
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[n-1][i]);
		}
		
		bw.append(String.valueOf(max));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
}