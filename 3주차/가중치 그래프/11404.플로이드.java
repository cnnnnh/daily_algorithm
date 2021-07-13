import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(br.readLine().trim());
		int[][] map = new int[n+1][n+1];
		final int INF = 1000000000;
		for (int i = 1; i <= n; i++) {
			Arrays.fill(map[i], INF);
			map[i][i] = 0;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = Math.min(map[a][b], c);
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				bw.append(map[i][j] == INF ? "0 " : String.valueOf(map[i][j]) + " ");
			}
			bw.newLine();
		}
		
		bw.flush();
		br.close();
		bw.close();
		
	}

}