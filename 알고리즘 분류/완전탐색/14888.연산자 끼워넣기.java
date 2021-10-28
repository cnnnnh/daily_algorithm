import java.io.*;
import java.util.*;

public class Main {

	static int n, MIN, MAX;
	static int[] num, operator;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());
		num = new int[n];
		operator = new int[4];
		MIN = Integer.MAX_VALUE;
		MAX = Integer.MIN_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		dfs(num[0], 1);
		bw.append(String.valueOf(MAX));
		bw.newLine();
		bw.append(String.valueOf(MIN));
		bw.flush();
		br.close();
		bw.close();
	}

	private static void dfs(int number, int index) {
		if (index == n) {
			MAX = Math.max(MAX, number);
			MIN = Math.min(MIN, number);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				operator[i]--;

				switch (i) {
				case 0:
					dfs(number + num[index], index + 1);
					break;
				case 1:
					dfs(number - num[index], index + 1);
					break;
				case 2:
					dfs(number * num[index], index + 1);
					break;
				case 3:
					dfs(number / num[index], index + 1);
					break;
				}

				operator[i]++;
			}

		}

	}

}