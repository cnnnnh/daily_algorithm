import java.io.*;
import java.util.*;

public class Main {
    
    static int n;
    static Integer[][] map, value;
    static Queue<Point> q;
    
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        int T = 1;
        
        while(true) {
        	n = Integer.parseInt(br.readLine());
        	if (n == 0) break;
        	
            map = new Integer[n][n];
            value = new Integer[n][n];
            q = new LinkedList<>();
            
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            value[0][0] = map[0][0];
            q.offer(new Point(0, 0, value[0][0]));
            rupee();
            
            System.out.println("Problem " + (T++) + ": " + value[n-1][n-1]);
        }
        
    }
    
    private static void rupee() {
    	while(!q.isEmpty()) {
    		Point cur = q.poll();
    		
        	for (int i = 0; i < 4; i++) {
        		int nx = cur.x + dx[i];
        		int ny = cur.y + dy[i];
        		
        		if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
        		
        		int ncoin = cur.coin + map[nx][ny];
        		
        		if (value[nx][ny] == null) {
        			value[nx][ny] = ncoin;
        			q.offer(new Point(nx, ny, ncoin));
        		}
        		else {
        			if(value[nx][ny] <= ncoin) {
        				continue;
        			}
        			value[nx][ny] = ncoin;
        			q.offer(new Point(nx, ny, ncoin));
        		}
        	}
    	}
    }
    
    static class Point {
    	int x;
    	int y;
    	int coin;
    	
    	public Point (int x, int y, int coin) {
    		this.x = x;
    		this.y = y;
    		this.coin = coin;
    	}
    }
}