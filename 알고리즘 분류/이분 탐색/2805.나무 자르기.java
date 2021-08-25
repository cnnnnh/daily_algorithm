/*
 * 어제 회고한 대로
 * 문제 잘 읽고 start = 0 한 거랑 long으로 선언한 거 칭찬해 ^-^
 * 부등호 사용만 잘 하기!
 */
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = arr[n-1];
		int mid = 0;
		long result = 0;
		long answer = 0;
		
		while(start <= end) {
			mid = (start + end) / 2;
			result = 0;
			
			for (int i = 0; i < n; i++) {
				if (arr[i] - mid <= 0) continue;
				result += (arr[i] - mid);
			}

			if (result >= m) {
				answer = mid;
				start = mid + 1;
			}
			else if (result < m) {
				end = mid - 1;
			}
			
		}
		
		bw.append(String.valueOf(answer));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
}