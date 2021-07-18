/*
 * dp 배열 자료형 신경 쓰자!
 * -> Integer를 쓸 것인지, Long을 쓸 것인지
 * 
 * Long 변수 초기화
 * 1. 숫자 뒤에 L 붙이기 ex) 1L, 2L
 * 2. long 캐스팅 ex) (long) 1, (long) 2
 */
import java.io.*;

public class Main {
	static Long[] dp;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		
		dp = new Long[101];
		dp[0] = 0L;
		dp[1] = 1L;
		dp[2] = 1L;
		dp[3] = 1L;
		
		while(T-- > 0) {
			int x = Integer.parseInt(br.readLine());
			bw.append(String.valueOf(triangle(x)) + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static long triangle(int x) {
		if (dp[x] == null) {
			return dp[x] = triangle(x-2) + triangle(x-3);
		}
		return dp[x];
	}
	
}