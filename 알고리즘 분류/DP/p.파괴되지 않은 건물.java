/*
 * �ְ� ���� DP�� ����...
 * ���� �� �˰��� ����� ���� �����տ� ���� �н��ߴ�.
 * �ش� ������ ���� ù �κа� ������ ������ �밢���� -degree, �� �ݴ뿡 +degree ������ �� �����ϱ�
 */

class Solution {
    public int solution(int[][] board, int[][] skill) {
    	// �������� ���� �迭 ���� (�����¿�� �� �� �ϳ��� �߰�)
        int[][] map = new int[board.length+2][board[0].length+2];
        
        for(int i = 0; i < skill.length; i++) {
            int type = (skill[i][0] == 1 ? -1 : 1);
            int start_x = skill[i][1] + 1;
            int start_y = skill[i][2] + 1;
            int end_x = skill[i][3] + 1;
            int end_y = skill[i][4] + 1;
            int degree = skill[i][5];
            // �������� ���� degree ���ϱ�
            map[start_x][start_y] += degree * type;
            map[start_x][end_y+1] += degree * type * (-1);
            map[end_x+1][start_y] += degree * type * (-1);
            map[end_x+1][end_y+1] += degree * type;
        }
        
        // ������ �迭 ����
        for(int i = 1; i < map.length-1; i++) {
            for(int j = 1; j < map[i].length-1; j++) {
                int temp = map[i][j];
                map[i][j] = map[i-1][j] + map[i][j-1] - map[i-1][j-1] + temp;
            }
        }
        
        // board�� ���� ��, �ı� ���� üũ�Ͽ� answer++
        int answer = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] += map[i+1][j+1];
                answer += (board[i][j] > 0 ? 1 : 0);
            }
        }
        return answer;
    }
}