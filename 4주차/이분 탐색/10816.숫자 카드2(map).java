/*
 * map으로 풀어도 풀린다!
 * 다만 메모리는 더 많이 잡아먹음...
 */
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			if (map.containsKey(x)) {
				map.put(x, map.get(x) + 1);
			}
			else {
				map.put(x, 1);
			}
		}
		
		
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int x = Integer.parseInt(st.nextToken());
			if (map.containsKey(x)) {
				bw.append(String.valueOf(map.get(x)) + " ");
			}
			else {
				bw.append("0 ");
			}
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	
}