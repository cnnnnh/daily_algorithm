import java.util.*;
import java.io.*;

/*
 * 이제 골드 4는 선녀 수준...
 * 이렇게만 나와죠...
 */

public class Main {
    
    static int N, sum, answer, max, min;
    static int[][] board;
    static boolean[][] section;
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        sum = 0;
        answer = Integer.MAX_VALUE;
        board = new int[N][N];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                sum += board[i][j];
            }
        }
        
        makeSection();
        System.out.println(answer);
        
    }
    
    public static void makeSection() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int d1 = 1; d1 < N; d1++) {
                    for(int d2 = 1; d2 < N; d2++) {
                        if((j+d2) >= N || (i+d1+d2) >= N || (j-d1) < 0) continue;
                        section = new boolean[N][N];
                        max = Integer.MIN_VALUE;
                        min = Integer.MAX_VALUE;
                        
                        for(int k = 0; k <= d1; k++) {
                            section[i+k][j-k] = true;
                            section[i+d2+k][j+d2-k] = true;
                        }
                        for(int k = 0; k <= d2; k++) {
                            section[i+k][j+k] = true;
                            section[i+d1+k][j-d1+k] = true;
                        }
                        
                        int result = calculate(i+d1, i+d2, j, j-d1+d2);
                        answer = Math.min(answer, result);
                    }
                }
            }
        }
    }
    
    public static int calculate(int x1, int x2, int y1, int y2) {
        int result = 0;
        int total = sum;

        // 1구역 합 구한 뒤 최대/최소 갱신
        for(int i = 0; i < x1; i++) {
        	for(int j = 0; j <= y1; j++) {
        		if(section[i][j]) break;
        		result += board[i][j];
        	}
        }
        max = Math.max(max, result);
        min = Math.min(min, result);
        total -= result;

        // 2구역 합 구한 뒤 최대/최소 갱신
        result = 0;
        for(int i = 0; i <= x2; i++) {
        	for(int j = N-1; j > y1; j--) {
        		if(section[i][j]) break;
        		result += board[i][j];
        	}
        }
        max = Math.max(max, result);
        min = Math.min(min, result);
        total -= result;

        // 3구역 합 구한 뒤 최대/최소 갱신
        result = 0;
        for(int i = x1; i < N; i++) {
        	for(int j = 0; j < y2; j++) {
        		if(section[i][j]) break;
        		result += board[i][j];
        	}
        }
        max = Math.max(max, result);
        min = Math.min(min, result);
        total -= result;
        
        // 4구역 합 구한 뒤 최대/최소 갱신
        result = 0;
        for(int i = x2+1; i < N; i++) {
        	for(int j = N-1; j >= y2; j--) {
        		if(section[i][j]) break;
        		result += board[i][j];
        	}
        }
        max = Math.max(max, result);
        min = Math.min(min, result);
        total -= result;
        
        // 5구역(나머지) 합 비교하여 최대/최소 갱신
        max = Math.max(max, total);
        min = Math.min(min, total);
        
        // 최대-최소 반환
        return max - min;
    }
    
}