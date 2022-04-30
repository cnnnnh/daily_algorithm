import java.util.*;
import java.io.*;

/*
 * 문제 좀 잘 읽으세요 나현님 ^^
 */

public class Main {
	
    static int N, M, K;
    static int[][] map;
    static ArrayList<Point> fireball;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        fireball = new ArrayList<>();
        
        int x, y, m, s, d;
        for(int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
        	x = Integer.parseInt(st.nextToken()) - 1;
        	y = Integer.parseInt(st.nextToken()) - 1;
        	m = Integer.parseInt(st.nextToken());
        	s = Integer.parseInt(st.nextToken());
        	d = Integer.parseInt(st.nextToken());
        	fireball.add(new Point(x, y, m, s, d));
        }
        
        for(int i = 0; i < K; i++) {
        	move();
        }
        
        int answer = 0;
        for(Point p : fireball) answer += p.m;
        
        System.out.println(answer);
    }
    
    public static void move() {
    	int nx, ny;
    	Point p;
    	int[][] map = new int[N][N];
    	ArrayList<Point> newList = new ArrayList<>();
    	
    	for(int i = 0; i < fireball.size(); i++) {
    		p = fireball.get(i);
    		// 속력과 방향에 맞게 이동
    		nx = p.x + (dx[p.d] * p.s);
    		ny = p.y + (dy[p.d] * p.s);
    		
    		// 범위 밖 처리
			while(nx < 0) nx += N;
			while(nx >= N) nx -= N;
			while(ny < 0) ny += N;
			while(ny >= N) ny -= N;
			
    		newList.add(new Point(nx, ny, p.m, p.s, p.d));
    		// 현재 좌표에 있는 파이어볼 개수 더하기
    		map[nx][ny]++;
    	}
    	
    	// fireball 리스트 비우고, 새로운 리스트 좌표순 정렬
    	fireball.clear();
    	Collections.sort(newList);
    	divide(newList, map);
    }
    
    public static void divide(ArrayList<Point> list, int[][] map) {
    	Point p;
    	int m, s, j;
    	boolean d, dir, resultDir;
    	for(int i = 0; i < list.size(); i++) {
    		p = list.get(i);
    		// 현재 좌표에 2개 이상의 파이어볼이 있을 때
    		if(map[p.x][p.y] > 1) {
    			m = p.m;
    			s = p.s;
    			// 현재 방향이 홀수면 false, 짝수면 true
    			d = (p.d % 2 != 0 ? false : true);
    			// 모든 방향이 홀수/짝수인지 구별
    			resultDir = false;
    			j = i+1;
    			for(; j < i + map[p.x][p.y]; j++) {
    				m += list.get(j).m;
    				s += list.get(j).s;
    				dir = (list.get(j).d % 2 != 0 ? false : true);
    				if(d != dir) resultDir = true;
    			}
    			
    			m /= 5;
    			s /= map[p.x][p.y];
    			i = j-1;
    			
    			// 질량이 0이면 넘어가기
    			if(m == 0) continue;
    			
    			// 방향이 다를 때
    			if(resultDir) {
    				fireball.add(new Point(p.x, p.y, m, s, 1));
    				fireball.add(new Point(p.x, p.y, m, s, 3));
    				fireball.add(new Point(p.x, p.y, m, s, 5));
    				fireball.add(new Point(p.x, p.y, m, s, 7));
    			}
    			else {
    				fireball.add(new Point(p.x, p.y, m, s, 0));
    				fireball.add(new Point(p.x, p.y, m, s, 2));
    				fireball.add(new Point(p.x, p.y, m, s, 4));
    				fireball.add(new Point(p.x, p.y, m, s, 6));
    			}
    			
    		}
    		else fireball.add(p);
    	}
    }
    
    static class Point implements Comparable<Point> {
    	int x, y, m, s, d;
    	
    	public Point(int x, int y, int m, int s, int d) {
    		this.x = x;
    		this.y = y;
    		this.m = m;
    		this.s = s;
    		this.d = d;
    	}
    	
    	@Override
    	public int compareTo(Point p) {
    		if(p.x == this.x) {
    			return this.y - p.y;
    		}
    		return this.x - p.x;
    	}
    }
    
}