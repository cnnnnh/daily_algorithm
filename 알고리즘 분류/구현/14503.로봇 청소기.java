import java.util.*;
import java.io.*;

public class Main {
	
    public static void main (String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	st = new StringTokenizer(br.readLine());
    	int x = Integer.parseInt(st.nextToken());
    	int y = Integer.parseInt(st.nextToken());
    	int dir = Integer.parseInt(st.nextToken());

    	int[][] board = new int[n][m];
    	
    	for(int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < m; j++) {
    			board[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	// �� �� �� �� (�ð����)
    	int[] dx = {-1, 0, 1, 0};
    	int[] dy = {0, 1, 0, -1};
    	
    	// 2a�� ���� Ƚ��, û���� ĭ
    	int cnt = 0, block = 1;
    	// ������ ��ġ
    	int nx = 0, ny = 0;
    	
    	// ù ĭ û��
    	board[x][y] = -1;
    	
    	while(true) {
    		// 2a���� 4�� �������� ��
    		if(cnt == 4) {
    			// ���� ���� ���ϱ�
    			int temp_dir = dir+2;
    			if(temp_dir >= 4) temp_dir -= 4;
    			nx = x + dx[temp_dir];
    			ny = y + dy[temp_dir];
    			// ������ ���� �ƴ� ��, ����
    			if(board[nx][ny] != 1) {
    				x = nx;
    				y = ny;
    				cnt = 0;
    			}
    			// ������ ���� ��, ����
    			else {
    				break;
    			}
    		}
    		// �������� ȸ��
			dir = (dir == 0 ? 3 : dir-1);
			nx = x + dx[dir];
			ny = y + dy[dir];
    		cnt++;
    		
			// ������ ����ų�, û���� �� �ִ� ĭ�� �ƴ� ��
			if(nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] != 0) continue;
			
			// �̵� �� û��
			x = nx;
			y = ny;
			board[nx][ny] = -1;
			block++;
			cnt = 0;
    	}
    	
    	System.out.println(block);
    	
    }
    
}