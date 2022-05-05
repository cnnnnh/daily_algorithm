import java.util.*;

/*
 * ���� �� �˾Ҵµ� ���� ���� �����ؾ� ����...
 * �����ϰ� ����!
 */

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        Queue<int[]> q;
        
        for(int i = 0; i < 5; i++) {
            char[][] map = new char[5][5];
            boolean flag = false;
            
            for(int j = 0; j < 5; j++) {
                map[j] = places[i][j].toCharArray();
            }
            
            label:
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    if(map[j][k] == 'P') {
                    	q = new LinkedList<>();
                        q.offer(new int[] {j, k, 0});
                        // �Ÿ��α� ����
                        if(!bfs(map, q)) {
                            flag = true;
                            break label;
                        }
                    }
                }
            }
            
            if(flag) answer[i] = 0;
            else answer[i] = 1;
            
        }
        
        return answer;
        
    }
    
    public static boolean bfs(char[][] map, Queue<int[]> q) {
        int nx, ny;
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};
        boolean[][] visited = new boolean[5][5];
        // ������ �湮 ó��
        visited[q.peek()[0]][q.peek()[1]] = true;
        
        while(!q.isEmpty()) {
            int[] arr = q.poll();
            // ����ư �Ÿ� ������ ��
            if(arr[2] == 2) continue;
            
            for(int i = 0; i < 4; i++) {
                nx = arr[0] + dx[i];
                ny = arr[1] + dy[i];
                
                // ���� ���̰ų� �湮���� ��
                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                if(visited[nx][ny]) continue;
                
                // �湮 ó��
                visited[nx][ny] = true;
                
                // ����� ������ �Ÿ��α� ����
                if(map[nx][ny] == 'P') return false;
                else if(map[nx][ny] == 'O') q.offer(new int[] {nx, ny, arr[2] + 1});
            }
            
        }
        
        return true;
    }
    
}