import java.io.*;

public class Main {
	static Integer[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		dp = new Integer[1000001];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
		bw.append(String.valueOf(tile(n)));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static int tile(int x) {
		if (dp[x] == null) {
			return dp[x] = (tile(x-1) + tile(x-2)) % 15746;
		}
		return dp[x];
	}
	
}