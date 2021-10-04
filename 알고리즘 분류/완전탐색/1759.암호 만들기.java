import java.io.*;
import java.util.*;

public class Main {
	
	static int L, C;
	static char[] alphabet;
	static boolean[] selected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alphabet = new char[C];
		selected = new boolean[C];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(alphabet);
		dfs (0, 0, 0, 0);
		
		br.close();
		
	}
	
	public static void dfs (int start, int cnt, int con, int vow) {
		if (cnt == L && con >= 2 && vow >= 1) {
			for (int i = 0; i < C; i++) {
				if (selected[i]) System.out.print(alphabet[i]);
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < C; i++) {
			selected[i] = true;
			dfs(i+1, cnt+1, con + (isVowel(alphabet[i]) ? 0 : 1), vow + (isVowel(alphabet[i]) ? 1 : 0));
			selected[i] = false;
		}
		
	}
	
	public static boolean isVowel (char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
		return false;
	}

}