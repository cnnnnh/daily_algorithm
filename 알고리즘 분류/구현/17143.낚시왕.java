import java.util.*;
import java.io.*;

/*
 * 낚시왕이 되고싶었던 최나현...
 * 모든 상황을 고려하자...
 * 입력값도 믿지 말자...
 * 나만 믿자...
 */

public class Main {
	
	static int r, c, answer;
	static int[][] sharkSize;
	static ArrayList<Shark>[] list;
	static Queue<Shark> queue;
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        answer = 0;
        
        // 해당 칸에 가장 큰 상어 크기 담는 배열
    	sharkSize = new int[r+1][c+1];
        
        // 같은 y좌표에 있는 상어들 묶어서 list화
        list = new ArrayList[c+1];
        for(int i = 1; i <= c; i++) {
        	list[i] = new ArrayList<>();
        }
        
        int x, y, s, d, z;
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	x = Integer.parseInt(st.nextToken());
        	y = Integer.parseInt(st.nextToken());
        	s = Integer.parseInt(st.nextToken());
        	d = Integer.parseInt(st.nextToken());
        	z = Integer.parseInt(st.nextToken());
        	sharkSize[x][y] = z;
        	
        	// 상 좌 하 우 순으로 변경
        	if(d == 1) d = 0;
        	else if(d == 4) d = 1;
        	
        	// 가장자리 방향을 안쪽으로 정리
        	if(x == 1 && d == 0) d = 2;
        	if(x == r && d == 2) d = 0;
        	if(y == 1 && d == 1) d = 3;
        	if(y == c && d == 3) d = 1;
        	list[y].add(new Shark(x, y, s, d, z));
        }
        
        // 사람 위치
        int person = 0;
        while(++person <= c) {
        	catchShark(person);
        	moveShark();
        }
        
    	System.out.println(answer);
    	
    }
    
    // 상어 잡기
    public static void catchShark(int index) {
    	// 상어가 없을 때
    	if(list[index].size() == 0) return;
    	// x 기준 오름차순 정렬해서 가장 가까운 상어 잡기
    	Collections.sort(list[index], (o1, o2) ->  o1.x - o2.x);
    	answer += list[index].get(0).size;
    	list[index].remove(0);
    }
    
    // 상어 움직이기
    public static void moveShark() {
    	sharkSize = new int[r+1][c+1];
    	queue = new LinkedList<>();
    	
    	// 상어 한 마리씩 움직이기
    	for(int i = 1; i <= c; i++) {
    		for(int j = 0; j < list[i].size(); j++) {
    			// 상어 한 마리 움직이기
    			Shark s = moveOneShark(list[i].get(j));
    			// 이 상어가 가장 큰 상어일 때
    			if(sharkSize[s.x][s.y] < s.size) {
    				sharkSize[s.x][s.y] = s.size;
    				queue.offer(s);
    			}
    		}
    	}
    	
    	// list 초기화
    	for(int i = 1; i <= c; i++) {
    		list[i].clear();
    	}
    	
    	// 상어 크기 배열 값을 갱신한 상어들을 담은 queue
    	while(!queue.isEmpty()) {
    		Shark s = queue.poll();
    		// 상어 크기가 최대값인 것들만 list add
    		if(s.size != sharkSize[s.x][s.y]) continue;
    		list[s.y].add(s);
    	}
    	
    }
    
    // 상어 한 마리 움직이기
    public static Shark moveOneShark(Shark s) {
    	// 스피드 간소화
    	Shark newShark = calculateSpeed(s);
    	int speed = newShark.speed;
    	while(speed-- > 0) {
    		switch(newShark.dir) {
    		case 0:
    			newShark.x--;
    			if(newShark.x == 1) 
        			newShark.dir = ((newShark.dir+2) % 4);
    			break;
    		case 1:
    			newShark.y--;
    			if(newShark.y == 1) 
        			newShark.dir = ((newShark.dir+2) % 4);
    			break;
    		case 2:
    			newShark.x++;
    			if(newShark.x == r) 
        			newShark.dir = ((newShark.dir+2) % 4);
    			break;
    		case 3:
    			newShark.y++;
    			if(newShark.y == c) 
        			newShark.dir = ((newShark.dir+2) % 4);
    			break;
    		}
    	}

    	s.x = newShark.x;
    	s.y = newShark.y;
    	s.dir = newShark.dir;
    	
    	return s;
    }
    
    // 스피드 간소화
    public static Shark calculateSpeed(Shark s) {
    	Shark newShark = new Shark(s.x, s.y, s.speed, s.dir, s.size);
    	if(newShark.speed == 0) return newShark;
    	// 같은 자리, 같은 방향인 경우
    	if(newShark.dir % 2 == 0) {
    		newShark.speed %= (2 * (r-1));
    	}
    	else {
    		newShark.speed %= (2 * (c-1));
    	}
    	return newShark;
    }
    
    static class Shark {
    	int x, y, speed, dir, size;
    	
    	public Shark(int x, int y, int speed, int dir, int size) {
    		this.x = x;
    		this.y = y;
    		this.speed = speed;
    		this.dir = dir;
    		this.size = size;
    	}
    }
    
}