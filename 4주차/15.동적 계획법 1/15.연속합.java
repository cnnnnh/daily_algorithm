/*
 * 두 가지 경우의 수를 비교해보고
 * 최댓값을 메모이제이션 해주기.
 */
import java.io.*;
import java.util.*;

public class Main {
	static Integer[] arr, dp;
	static int max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		arr = new Integer[n];
		dp = new Integer[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		max = arr[0];
		sum(n-1);
		
		bw.append(String.valueOf(max));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static int sum(int x) {
		if (dp[x] == null) {
			dp[x] = Math.max(arr[x], sum(x-1) + arr[x]);
			max = Math.max(max, dp[x]);
		}
		return dp[x];
	}
	
}