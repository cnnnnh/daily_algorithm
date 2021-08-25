/*
 * 1. 자료형 좀 살피기!!!
 * 	  : int 쓸 건지, long 쓸 건지 잘 판단하자 ^-^
 * 2. 최솟값 생각하기
 * 	  : 0cm인 랜선은 없음. 최솟값은 1이다. 문제를 잘 읽자 ^-^
 */
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[k];
		
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		long start = 1;
		long end = arr[k-1];
		long mid = 0;
		long answer = 0;
		int cnt = 0;
		
		while(start <= end) {
			mid = (start + end) / 2;
			cnt = 0;
			
			for (int i : arr) {
				cnt += i / mid;
				if (cnt > n) {
					break;
				}
			}
			
			if (cnt >= n) {
				answer = mid;
				start = mid + 1;
			}
			else if (cnt < n) {
				end = mid - 1;
			}
			
		}
		
		bw.append(String.valueOf(answer));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
}