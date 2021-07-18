import java.io.*;
import java.util.*;

public class Main {
	static Integer[][][] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		dp = new Integer[21][21][21];
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1 && c == -1) break;
			bw.append("w(" + String.valueOf(a) + ", " + String.valueOf(b) + ", " + String.valueOf(c) + ") = " + String.valueOf(w(a, b, c)));
			bw.newLine();
		}
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		if (a > 20 || b > 20 || c > 20) {
			return w(20, 20, 20);
		}
		if (dp[a][b][c] != null) {
			return dp[a][b][c];
		}
		if (a < b && b < c) {
			return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		}
		else {
			return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
		}
	}
	
}