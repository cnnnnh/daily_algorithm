import java.util.*;
import java.io.*;

/*
 * 이 문제에만 이틀을 쓴 나현... ^^
 * 규칙을 찾는 연습을 하자!
 */

public class Main {
	
    public static void main (String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());

    	int n = Integer.parseInt(st.nextToken()), answer = 0, x, y, d ,g;
    	int[] dx = {1, 0, -1, 0};
    	int[] dy = {0, -1, 0, 1};
    	boolean[][] map = new boolean[101][101];
    	ArrayList<Integer> list = new ArrayList<>();
    	
    	for(int t = 0; t < n; t++) {
    		st = new StringTokenizer(br.readLine());
    		x = Integer.parseInt(st.nextToken());
    		y = Integer.parseInt(st.nextToken());
    		d = Integer.parseInt(st.nextToken());
    		g = Integer.parseInt(st.nextToken());
    		
    		map[x][y] = true;
    		list.add(d);
    		
    		for(int i = 1; i <= g; i++) {
    			for(int j = list.size()-1; j >= 0; j--) {
    				list.add((list.get(j) + 1) % 4);
    			}
    		}
    		
    		for(int dir : list) {
    			x += dx[dir];
    			y += dy[dir];
    			map[x][y] = true;
    		}
    		
    		list.clear();
    	}
    	
    	for(int i = 0; i < 100; i++) {
    		for(int j = 0; j < 100; j++) {
    			if(map[i][j] && map[i+1][j]
    					&& map[i][j+1] && map[i+1][j+1]) answer++;
    		}
    	}
    	
    	System.out.println(answer);
    }
    
}
