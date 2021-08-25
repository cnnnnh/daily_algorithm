import java.io.*;
import java.util.*;

public class Main {
	static Long[][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		dp = new Long[n+1][10];
		
		for (int i = 0; i <= 9; i++) {
			dp[1][i] = 1L;
		}
		
		long result = 0;
		for (int i = 1; i <= 9; i++) {
			result += cal(n, i);
		}
		
		bw.append(String.valueOf(result % 1000000000));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static long cal(int num, int index) {
		if (num == 1) return dp[num][index];
		
		if (dp[num][index] == null) {
			if (index == 0) {
				dp[num][index] = cal(num-1, 1);
			}
			else if (index == 9) {
				dp[num][index] = cal(num-1, 8);
			}
			else {
				dp[num][index] = cal(num-1, index-1) + cal(num-1, index+1);
			}
		}
		return dp[num][index] % 1000000000;
	}
	
}