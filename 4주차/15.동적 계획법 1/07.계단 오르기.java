import java.io.*;

public class Main {
	static Integer[] cost, dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		cost = new Integer[n+1];
		dp = new Integer[n+1];
		
		for (int i = 1; i <= n; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0] = cost[0] = 0;
		dp[1] = cost[1];
		if (n >= 2) dp[2] = cost[1] + cost[2];
		
		bw.append(String.valueOf(find(n)));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static int find(int x) {
		if (dp[x] == null) {
			dp[x] = Math.max(find(x-2), find(x-3) + cost[x-1]) + cost[x];
		}
		return dp[x];
	}
	
}