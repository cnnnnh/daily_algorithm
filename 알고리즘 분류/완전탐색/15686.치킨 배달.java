import java.io.*;
import java.util.*;

public class Main {
	
	static int m, answer;
	static int[] number, min;
	static int[][] distance, result;
	static ArrayList<int[]> house, chicken;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				if (temp == 1) house.add(new int[] {i, j});
				else if (temp == 2) chicken.add(new int[] {i, j});
			}
		}
		
		result = new int[chicken.size()][house.size()];
		
		for (int i = 0; i < chicken.size(); i++) {
			for (int j = 0; j < house.size(); j++) {
				result[i][j] = Math.abs(chicken.get(i)[0] - house.get(j)[0])
						+ Math.abs(chicken.get(i)[1] - house.get(j)[1]);
			}
		}
		
		number = new int[m];
		min = new int[house.size()];
		answer = Integer.MAX_VALUE;
		cal(0, 0);
		
		bw.append(String.valueOf(answer));
		bw.flush();
		br.close();
		bw.close();
		
	}
	
	private static void cal(int start, int cnt) {
		if (cnt == m) {
			Arrays.fill(min, Integer.MAX_VALUE);
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < house.size(); j++) {
					if (min[j] > result[number[i]][j])
						min[j] = result[number[i]][j];
				}
			}
			int total = 0;
			for (int i = 0; i < min.length; i++) {
				total += min[i];
			}
			answer = Math.min(answer, total);
			return;
		}
		
		for (int i = start; i < chicken.size(); i++) {
			number[cnt] = i;
			cal(i+1, cnt+1);
		}
	}
	
}