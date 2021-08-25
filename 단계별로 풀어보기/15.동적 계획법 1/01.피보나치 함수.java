/*
 * Integer[] 은 null로 초기화되어있음!
 */
import java.io;

public class Main {
	static int T;
	static Integer[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		dp = new Integer[41][2];
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		while (T-- > 0) {
			int x = Integer.parseInt(br.readLine());
			fibonacci(x);
			bw.append(String.valueOf(dp[x][0]) + " " + String.valueOf(dp[x][1]) + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static Integer[] fibonacci(int x) {
		if (dp[x][0] == null || dp[x][1] == null) {
			dp[x][0] = fibonacci(x-1)[0] + fibonacci(x-2)[0];
			dp[x][1] = fibonacci(x-1)[1] + fibonacci(x-2)[1];
		}
		return dp[x];
	}
	
}