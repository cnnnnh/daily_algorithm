/*
 * 머리를 쓰자 나현아.....
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
		int[] num = new int[n];
		int min = 1;
		int max = n;
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			int cnt = n-i-1;
			if (sum+cnt < k) {
				sum += cnt;
				num[i] = max--;
			}
			else if (sum+cnt == k) {
				sum += cnt;
				num[i] = max--;
				for (int j = i+1; j < n; j++) {
					num[j] = min++;
				}
				break;
			}
			else {
				num[i] = min++;
			}
		}
		
		for (int i : num) {
			bw.append(String.valueOf(i) + " ");
		}
		
		bw.newLine();
		bw.flush();
		br.close();
		bw.close();
		
	}

}
