package main;

import java.io.*;
import java.util.*;

public class Main {
	
	static int N, min;
	static int[] place, order;
	static boolean[] selected;
	static ArrayList<int[]> list;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int tc = Integer.parseInt(br.readLine().trim());
		
		for(int T = 1; T <= tc; T++) {
			
			N = Integer.parseInt(br.readLine().trim());
			min = Integer.MAX_VALUE;
			
			place = new int[N+1];
			order = new int[3];
			selected = new boolean[3];
			list = new ArrayList<>();
			
			for(int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
			permutation(0);
			System.out.println("#" + T + " " + min);
		}
			
	}
	
	public static void permutation(int cnt) {
		if(cnt == 3) {
			int[] arr = new int[N+1];
			seatPlace(list.get(order[0])[0], list.get(order[0])[1], 0, 0, arr);
			return;
		}
		
		for(int i = 0; i < 3; i++) {
			if(selected[i]) continue;
			selected[i] = true;
			order[cnt] = i;
			permutation(cnt+1);
			selected[i] = false;
		}
	}
	
	
	public static void seatPlace(int door, int person, int range, int index, int[] arr) {
		boolean flag = false;
		if (person == 0) {
			if (index == 2) {
				int result = 0;
				for(int i : place) result += i;
				min = Math.min(min, result);
				return;
			}
			int d = list.get(order[index+1])[0];
			int p = list.get(order[index+1])[1];
			seatPlace(d, p, 0, index+1, arr);
			return;
		}
		
		if((door - range) > 0 && place[door - range] == 0) {
			place[door - range] = range + 1;
			seatPlace(door, person-1, range, index, arr);
			place[door - range] = 0;
			flag = true;
		}
		if ((door + range) <= N && place[door + range] == 0) {
			place[door + range] = range + 1;
			seatPlace(door, person-1, range+1, index, arr);
			place[door + range] = 0;
			flag = true;
		}
		if (!flag) {
			seatPlace(door, person, range+1, index, arr);
		}
		
	}
	
	
}
