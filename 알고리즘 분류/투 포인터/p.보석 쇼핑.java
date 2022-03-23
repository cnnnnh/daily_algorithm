import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>();              // ���� ���� ����
        HashMap<String, Integer> map = new HashMap<>();     // ������ ����
        Queue<String> q = new LinkedList<>();               // ���� ����ִ� ������
        int[] answer = new int[] {1, gems.length};
        int index = 0;
        int len = gems.length;
        
        // ���� ���� ���
        for(int i = 0; i < gems.length; i++) {
            set.add(gems[i]);
        }
        
        for(int i = 0; i < gems.length; i++) {
            // ���� ������ ����
            if(map.containsKey(gems[i])) map.put(gems[i], map.get(gems[i]) + 1);
            else map.put(gems[i], 1);
            
            // ���� ���� ����Ʈ�� �߰�
            q.offer(gems[i]);
            
            while(true) {
                String gem = q.peek();
                // 2�� �̻� �ִ� �����̸� ����
                if(map.get(gem) > 1) {
                    q.poll();
                    map.put(gem, map.get(gem) - 1);
                    // ���� �ε��� ����
                    index++;
                }
                // 1�� ���� �ִ� �����̸� �� ����, �ٸ� ���� �� �ֱ�
                else break;
            }
            
            // ���� ���� �� ���� == ������ �ִ� ���� ���� ����,
            // ������ �ִ� ���� ���� < ���� �ּ� ���� ������ ��
            if(set.size() == map.size() && len > q.size()) {
                len = q.size();
                answer[0] = index + 1;
                answer[1] = index + len;
            }
            
        }
        
        
        return answer;
    }
}