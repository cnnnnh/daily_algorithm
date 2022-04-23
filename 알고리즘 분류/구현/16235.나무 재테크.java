import java.util.*;
import java.io.*;

/*
 * list로 후루룩 풀었는데 시간초과 잼
 * sort하는 것에서 많은 시간이 소요됐을 것으로 추측됨...
 * 
 * 입력값의 좌표는 중복되지 않는다 = 처음엔 정렬 필요 없다는 뜻이라서
 * deque 사용하여 앞뒤로 붙이면서 나이 순 정렬 해줬음
 */

public class Main {
	
	static int n, m, k;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int[][] A, map;
	static Deque<Tree> treeDeque, newDeque, dieDeque;
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        A = new int[n][n];
        map = new int[n][n];
        treeDeque = new ArrayDeque<>();
    	newDeque = new ArrayDeque<>();
    	dieDeque = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < n; j++) {
        		A[i][j] = Integer.parseInt(st.nextToken());
        		map[i][j] = 5;
        	}
        }
        
        int x, y, z;
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	x = Integer.parseInt(st.nextToken());
        	y = Integer.parseInt(st.nextToken());
        	z = Integer.parseInt(st.nextToken());
        	treeDeque.offer(new Tree(x-1, y-1, z));
        }
        
        while(k-- > 0) {
        	spring();
        	summer();
        	fall();
        	winter();
        }
        
        System.out.println(treeDeque.size());
        
    }
    
    public static void spring() {
    	while(!treeDeque.isEmpty()) {
    		Tree t = treeDeque.poll();
    		if(map[t.x][t.y] - t.age >= 0) {
    			map[t.x][t.y] -= t.age;
    			t.age++;
    			newDeque.offer(t);
    		}
    		else {
    			dieDeque.offer(t);
    		}
    	}
    }
    
    public static void summer() {
    	while(!dieDeque.isEmpty()) {
    		Tree t = dieDeque.poll();
    		map[t.x][t.y] += t.age/2;
    	}
    }
    
    public static void fall() {
    	int nx, ny;
    	while(!newDeque.isEmpty()) {
    		Tree t = newDeque.poll();
    		if(t.age % 5 == 0) {
        		for(int i = 0; i < 8; i++) {
        			nx = t.x + dx[i];
        			ny = t.y + dy[i];
        			if(isIn(nx, ny)) {
        				treeDeque.offerFirst(new Tree(nx, ny, 1));
        			}
        		}
        	}
    		treeDeque.offerLast(t);
    	}
    }
    
    public static void winter() {
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			map[i][j] += A[i][j];
    		}
    	}
    }
    
    public static boolean isIn(int x, int y) {
    	if(x < 0 || x >= n || y < 0 || y >= n) return false;
    	return true;
    }
    
    static class Tree {
    	int x, y, age;
    	
    	public Tree(int x, int y, int age) {
    		this.x = x;
    		this.y = y;
    		this.age = age;
    	}
    }
    
}