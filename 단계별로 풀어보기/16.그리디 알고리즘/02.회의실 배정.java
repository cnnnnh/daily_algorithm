/*
 * comparator 사용법 익히기!
 * 회의가 끝나는 기준으로 정렬해야 하는 게 핵심.
 * 문제 이해력은 언제 키워질까? ^^
 * 이러다가... 갑자기... 급성장할 거라고... 믿는다... 따흐흑
 */
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return Integer.compare(o1[0], o2[0]);
				}
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		int end = -1;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i][0] >= end) {
				end = arr[i][1];
				cnt++;
			}
		}
		
		bw.append(String.valueOf(cnt));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
}