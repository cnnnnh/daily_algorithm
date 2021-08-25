import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static Integer[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		dp = new Integer[n+1];
		dp[0] = dp[1] = 0;
		
		bw.append(String.valueOf(cal(n)));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static int cal(int x) {
		if (dp[x] == null) {
			if (x % 6 == 0) {
				dp[x] = Math.min(Math.min(cal(x/2), cal(x/3)), cal(x-1)) + 1;
			}
			else if (x % 3 == 0) {
				dp[x] = Math.min(cal(x/3), cal(x-1)) + 1;
			}
			else if (x % 2 == 0) {
				dp[x] = Math.min(cal(x/2), cal(x-1)) + 1;
			}
			else {
				dp[x] = cal(x-1) + 1;
			}
		}
		
		return dp[x];
	}
	
}