import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());
        int[][][] map = new int[z][x][y];
        int[] dx = {0, -1, 0, 1, 0, 0};
        int[] dy = {-1, 0, 1, 0, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};
        Queue<Point> q = new LinkedList<>();
        
        for (int i = 0; i < z; i++) {
        	for (int j = 0; j < x; j++) {
        		st = new StringTokenizer(br.readLine());
        		for (int k = 0; k < y; k++) {
        			map[i][j][k] = Integer.parseInt(st.nextToken());
        			// 익은 토마토 큐에 삽입
        			if (map[i][j][k] == 1) {
        				q.offer(new Point(j, k, i));
        			}
        		}
        	}
        }
        
        while(!q.isEmpty()) {
        	Point p = q.poll();
        	for (int i = 0; i < 6; i++) {
        		int nx = p.x + dx[i];
        		int ny = p.y + dy[i];
        		int nz = p.z + dz[i];
        		if (nx >= 0 && nx < x && ny >= 0 && ny < y && nz >= 0 && nz < z) {
        			// 안 익은 토마토 익게 만들기
        			if (map[nz][nx][ny] == 0) {
        				map[nz][nx][ny] = map[p.z][p.x][p.y] + 1;
        				q.offer(new Point(nx, ny, nz));
        			}
        		}
        	}
        }
        
        boolean flag = false;
        int max = 0;
        
        label:
        for (int i = 0; i < z; i++) {
        	for (int j = 0; j < x; j++) {
        		for (int k = 0; k < y; k++) {
        			// 안 익은 토마토가 있을 때
        			if (map[i][j][k] == 0) {
        				flag = true;
        				bw.append("-1");
        				break label;
        			}
        			else {
        				max = Math.max(max, map[i][j][k]);
        			}
        		}
        	}
        }
        
        if (!flag) {
        	bw.append(String.valueOf(max-1));
        }
        
        bw.flush();
        br.close();
        bw.close();
        
    }
    
    static class Point {
    	int x;
    	int y;
    	int z;
    	
    	public Point (int x, int y, int z) {
    		this.x = x;
    		this.y = y;
    		this.z = z;
    	}
    	
    }
}