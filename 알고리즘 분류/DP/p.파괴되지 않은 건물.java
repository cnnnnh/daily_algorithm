/*
 * 멀고도 험한 DP의 세계...
 * 맞은 편 알고리즘 고수님 덕에 누적합에 대해 학습했다.
 * 해당 면적의 가장 첫 부분과 끝나는 지점의 대각선에 -degree, 그 반대에 +degree 대입한 후 연산하기
 */

class Solution {
    public int solution(int[][] board, int[][] skill) {
    	// 누적합을 위한 배열 생성 (상하좌우로 빈 줄 하나씩 추가)
        int[][] map = new int[board.length+2][board[0].length+2];
        
        for(int i = 0; i < skill.length; i++) {
            int type = (skill[i][0] == 1 ? -1 : 1);
            int start_x = skill[i][1] + 1;
            int start_y = skill[i][2] + 1;
            int end_x = skill[i][3] + 1;
            int end_y = skill[i][4] + 1;
            int degree = skill[i][5];
            // 누적합을 위한 degree 더하기
            map[start_x][start_y] += degree * type;
            map[start_x][end_y+1] += degree * type * (-1);
            map[end_x+1][start_y] += degree * type * (-1);
            map[end_x+1][end_y+1] += degree * type;
        }
        
        // 누적합 배열 연산
        for(int i = 1; i < map.length-1; i++) {
            for(int j = 1; j < map[i].length-1; j++) {
                int temp = map[i][j];
                map[i][j] = map[i-1][j] + map[i][j-1] - map[i-1][j-1] + temp;
            }
        }
        
        // board에 적용 후, 파괴 여부 체크하여 answer++
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