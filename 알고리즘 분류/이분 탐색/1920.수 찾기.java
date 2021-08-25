import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		
		int start, end, mid;
		boolean flag;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int x = Integer.parseInt(st.nextToken());
			start = 0;
			end = n-1;
			mid = 0;
			flag = false;
			
			while(start <= end) {
				mid = (start + end) / 2;
				if (x == arr[mid]) {
					flag = true;
					break;
				}
				else if (x > arr[mid]) {
					start = mid + 1;
				}
				else {
					end = mid - 1;
				}
			}
			
			if (flag) bw.append("1\n");
			else bw.append("0\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
}