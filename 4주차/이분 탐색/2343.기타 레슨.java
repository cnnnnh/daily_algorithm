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
		int start = 0;
		int end = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			start = Math.max(start, arr[i]);
			end += arr[i];
		}
		
		int mid, temp, cnt;
		
		while(start <= end) {
			mid = (start + end) / 2;
			temp = mid;
			cnt = 1;
			
			for (int i : arr) {
				if (i > temp) {
					temp = mid - i;
					cnt++;
				}
				else temp -= i;

				if (cnt > m) break;
			}
			
			if (cnt > m) start = mid + 1;
			else end = mid - 1;

		}
		
		bw.append(String.valueOf(end + 1));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
}