import java.util.*;
import java.io.*;

/*
 * ����ϰ� Ǯ�� �;����� �����ѵ� ^^
 * Ǯ���ٴ� �Ϳ� ū �ǹ̸� �ΰھ��~~~
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
    	
    	// ���� Ž��
    	for(int i = 0; i < n; i++) {
    		pre = map[i][0];
    		flag = false;
    		check = new boolean[n];
    		for(int j = 1; j < n; j++) {
    			// ��ĭ�� ���� ��
    			if(map[i][j] == pre) continue;
    			// ��ĭ���� �� ĭ ���� ��
    			else if (map[i][j] == pre-1) {
    				// ���� ���� ������ ��
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
    			// ��ĭ���� �� ĭ ���� ��
    			else if (map[i][j] == pre+1) {
    				// ���� ���� ������ ��
    				if(makeWay('r', i, j-L, j, pre)) {
    					pre++;
    					continue;
    				}
    				else {
    					flag = true;
    					break;
    				}
    			}
    			// ��ĭ���� �� ĭ �̻� ���̳� ��
    			else {
    				flag = true;
    				break;
    			}
    		}
    		if(!flag) {
    			answer++;
    		}
    	}
    	
    	
    	
    	// ���� Ž��
    	for(int i = 0; i < n; i++) {
    		pre = map[0][i];
    		flag = false;
    		check = new boolean[n];
    		for(int j = 1; j < n; j++) {
    			// ��ĭ�� ���� ��
    			if(map[j][i] == pre) continue;
    			// ��ĭ���� �� ĭ ���� ��
    			else if (map[j][i] == pre-1) {
    				// ���� ���� ������ ��
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
    			// ��ĭ���� �� ĭ ���� ��
    			else if (map[j][i] == pre+1) {
    				// ���� ���� ������ ��
    				if(makeWay('c', i, j-L, j, pre)) {
    					pre++;
    					continue;
    				}
    				else {
    					flag = true;
    					break;
    				}
    			}
    			// ��ĭ���� �� ĭ �̻� ���̳� ��
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
    
    // ���θ� ���� �� ������ true, ������ false
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
    
    // ���ΰ� ������ true, ������ false
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