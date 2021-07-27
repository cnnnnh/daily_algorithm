/*
 * 자료형을 신경 쓴다고 썼는데!
 * int * int가 long이 된다면 각 int 앞에 long 캐스팅 해주기.
 */
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] dis = new int[n-1];
		int[] cost = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n-1; i++) {
			dis[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		long answer = 0;
		int min_cost = Integer.MAX_VALUE;
		for (int i = 0; i < n-1; i++) {
			if (cost[i] < min_cost) {
				min_cost = cost[i];
			}
			answer += ((long)min_cost * (long)dis[i]);
		}
		
		bw.append(String.valueOf(answer));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
}