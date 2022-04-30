import java.util.*;
import java.io.*;

/*
 * 아 진짜 이렇게만 나와주면 안 될까?
 * 최나현 소원!
 */

public class Main {
	
    static int N, M, answer;
    static int[] number;
    static ArrayList<Point> houseList, chickenList;
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        number = new int[M];
        houseList = new ArrayList<>();
        chickenList = new ArrayList<>();
        
        int num;
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
        		num = Integer.parseInt(st.nextToken());
        		if(num == 1) houseList.add(new Point(i, j));
        		else if(num == 2) chickenList.add(new Point(i, j));
        	}
        }
        
        combination(0, 0);
        System.out.println(answer);
        
    }
    
    public static void combination(int start, int cnt) {
    	if(cnt == M) {
    		answer = Math.min(answer, calculateDistance());
    		return;
    	}
    	
    	for(int i = start; i < chickenList.size(); i++) {
    		number[cnt] = i;
    		combination(i+1, cnt+1);
    	}
    	
    }
    
    public static int calculateDistance() {
    	int result = 0, min, distance;
    	Point house, chicken;
    	for(int i = 0; i < houseList.size(); i++) {
    		house = houseList.get(i);
    		min = Integer.MAX_VALUE;
    		for(int j = 0; j < M; j++) {
    			chicken = chickenList.get(number[j]);
    			distance = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
    			min = Math.min(min, distance);
    		}
    		result += min;
    	}
    	return result;
    }
    
    static class Point {
    	int x, y;
    	
    	public Point(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }
    
}