/*
 * 첫번째 집에 공유기를 설치하고 그리디 알고리즘으로 문제 풀기.
 * 그 간격을 이분 탐색하여 찾는다!
 */
import java.io.*;
import java.util.*;

public class Main {
	static int[] map;
	static int n, c;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[n];
		
		for (int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(map);
		
		int start = 1;
		int end = map[n-1] - map[0];
		int mid = 0;
		
		while(start <= end) {
			mid = (start + end) / 2;
			if (check(mid)) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		
		bw.append(String.valueOf(end));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static boolean check(int num) {
		int cnt = 1;
		int start = map[0];
		for (int i = 0; i < n; i++) {
			if (map[i] - start < num) continue;
			start = map[i];
			cnt++;
		}
		if (cnt >= c) return true;
		return false;
	}
	
}