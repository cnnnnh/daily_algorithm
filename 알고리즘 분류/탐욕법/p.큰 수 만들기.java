import java.util.*;

// �׸��� ������ �׸���~~~

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int max = 0;
        int index = 0;
        
        for(int i = 0; i < number.length() - k; i++) {
            // �ִ� �ʱ�ȭ
            max = 0;
            // üũ�� �� �ִ� ���� (������ ���� ���� �ε��� ~ �����ؾ߸� �ϴ� ���� ���� ������ ������ ����)
            for(int j = index; j <= k + i; j++) {
                int num = number.charAt(j) - '0';
                // �ִ� ����
                if(max < num) {
                    max = num;
                    // ������ �� ���� �ε����� ����
                    index = j + 1;
                }
            }
            sb.append(max);
        }
        
        return sb.toString();
    }
}