import java.util.*;
import java.io.*;

/*
 * 깔끔하게 풀고 싶었지만 실패한듯 ^^
 * 풀었다는 것에 큰 의미를 두겠어용~~~
 */

public class Main {
	
	static int n;
	static int[][] map;
	static boolean[] check;
	
    public static void main (String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	int L = Integer.parseInt(st.nextToken());
    	
    	map = new int[n][n];
    	
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < n; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	int pre = 0, answer = 0;
    	boolean flag = false;
    	
    	// 가로 탐색
    	for(int i = 0; i < n; i++) {
    		pre = map[i][0];
    		flag = false;
    		check = new boolean[n];
    		for(int j = 1; j < n; j++) {
    			// 앞칸과 같을 때
    			if(map[i][j] == pre) continue;
    			// 앞칸보다 한 칸 낮을 때
    			else if (map[i][j] == pre-1) {
    				// 경사로 제작 가능할 때
    				if(makeWay('r', i, j, j+L, pre-1)) {
    					pre--;
    					j = (j+L-1);
    					continue;
    				}
    				else {
    					flag = true;
    					break;
    				}
    			}
    			// 앞칸보다 한 칸 높을 때
    			else if (map[i][j] == pre+1) {
    				// 경사로 제작 가능할 때
    				if(makeWay('r', i, j-L, j, pre)) {
    					pre++;
    					continue;
    				}
    				else {
    					flag = true;
    					break;
    				}
    			}
    			// 앞칸보다 두 칸 이상 차이날 때
    			else {
    				flag = true;
    				break;
    			}
    		}
    		if(!flag) {
    			answer++;
    		}
    	}
    	
    	
    	
    	// 세로 탐색
    	for(int i = 0; i < n; i++) {
    		pre = map[0][i];
    		flag = false;
    		check = new boolean[n];
    		for(int j = 1; j < n; j++) {
    			// 앞칸과 같을 때
    			if(map[j][i] == pre) continue;
    			// 앞칸보다 한 칸 낮을 때
    			else if (map[j][i] == pre-1) {
    				// 경사로 제작 가능할 때
    				if(makeWay('c', i, j, j+L, pre-1)) {
    					pre--;
    					j = (j+L-1);
    					continue;
    				}
    				else {
    					flag = true;
    					break;
    				}
    			}
    			// 앞칸보다 한 칸 높을 때
    			else if (map[j][i] == pre+1) {
    				// 경사로 제작 가능할 때
    				if(makeWay('c', i, j-L, j, pre)) {
    					pre++;
    					continue;
    				}
    				else {
    					flag = true;
    					break;
    				}
    			}
    			// 앞칸보다 두 칸 이상 차이날 때
    			else {
    				flag = true;
    				break;
    			}
    		}
    		if(!flag) {
    			answer++;
    		}
    	}
    	System.out.println(answer);
    	
    }
    
    // 경사로를 만들 수 있으면 true, 없으면 false
    public static boolean makeWay(char type, int index, int start, int end, int value) {
    	if(start < 0 || end > n) return false;
    	if(type == 'r') {
    		for(int i = start; i < end; i++) {
    			if(map[index][i] != value) return false;
    		}
    	}
    	else {
    		for(int i = start; i < end; i++) {
    			if(map[i][index] != value) return false;
    		}
    	}
    	if(isWay(start, end)) return false;
    	return true;
    }
    
    // 경사로가 있으면 true, 없으면 false
    public static boolean isWay (int start, int end) {
    	for(int i = start; i < end; i++) {
    		if(check[i]) {
    			for(int j = start; j < i; j++) {
    				check[j] = false;
    			}
    			return true;
    		}
    		check[i] = true;
    	}
    	return false;
    }
    
}