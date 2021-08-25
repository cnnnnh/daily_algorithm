/*
 * Arrays.sort(arr, Collections.reverseOrder());
 * : int는 객체가 아닌 primitive type
 * 	 -> Integer[]로 선언
 */
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Integer[] arr = new Integer[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		int index = 0;
		int cnt = 0;
		
		while(k != 0) {
			if (k >= arr[index]) {
				k -= arr[index];
				cnt++;
			}
			else index++;
		}

		bw.append(String.valueOf(cnt));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
}