import java.util.*;

// 그림을 열심히 그리자~~~

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int max = 0;
        int index = 0;
        
        for(int i = 0; i < number.length() - k; i++) {
            // 최댓값 초기화
            max = 0;
            // 체크할 수 있는 범위 (선택한 숫자 다음 인덱스 ~ 선택해야만 하는 숫자 개수 제외한 마지막 길이)
            for(int j = index; j <= k + i; j++) {
                int num = number.charAt(j) - '0';
                // 최댓값 갱신
                if(max < num) {
                    max = num;
                    // 선택한 수 다음 인덱스를 저장
                    index = j + 1;
                }
            }
            sb.append(max);
        }
        
        return sb.toString();
    }
}