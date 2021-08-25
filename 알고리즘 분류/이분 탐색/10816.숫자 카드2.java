/*
 * Map을 쓰려다가 익숙하지가 않아서 ArrayList 썼더니 시간초과 남.
 * 찾아보니 Map만 잘 사용했어도 통과했을듯 ^^
 * 그래도 색다른 방식으로 문제를 풀어봤다... 그것에 의의를 두자!
 */
import java.io.*;
import java.util.*;

public class Main {
	static int[] num;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		num = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int x = Integer.parseInt(st.nextToken());
			int lower = lower_bound(x);
			int upper = upper_bound(x);
			bw.append(String.valueOf(upper-lower) + " ");
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static int lower_bound(int x) {
		int start = 0;
		int end = num.length-1;
		int mid = 0;
		while(start < end) {
			mid = (start + end) / 2;
			if (num[mid] >= x) {
				end = mid;
			}
			else {
				start = mid + 1;
			}
		}
		return end;
	}
	
	private static int upper_bound(int x) {
		int start = 0;
		int end = num.length-1;
		int mid = 0;
		while(start < end) {
			mid = (start + end) / 2;
			if (num[mid] > x) {
				end = mid;
			}
			else {
				start = mid + 1;
			}
		}
		if (num[end] == x) end++;
		return end;
	}
	
}