import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> set = new HashSet<>();              // 보석 종류 개수
        HashMap<String, Integer> map = new HashMap<>();     // 보석과 개수
        Queue<String> q = new LinkedList<>();               // 현재 담고있는 보석들
        int[] answer = new int[] {1, gems.length};
        int index = 0;
        int len = gems.length;

        // 보석 종류 담기
        for(int i = 0; i < gems.length; i++) {
            set.add(gems[i]);
        }

        for(int i = 0; i < gems.length; i++) {
            // 보석 쓸어담기 시작
            if(map.containsKey(gems[i])) map.put(gems[i], map.get(gems[i]) + 1);
            else map.put(gems[i], 1);

            // 담은 보석 리스트에 추가
            q.offer(gems[i]);

            while(true) {
                String gem = q.peek();
                // 2개 이상 있는 보석이면 빼기
                if(map.get(gem) > 1) {
                    q.poll();
                    map.put(gem, map.get(gem) - 1);
                    // 시작 인덱스 변경
                    index++;
                }
                // 1개 이하 있는 보석이면 안 빼고, 다른 보석 더 넣기
                else break;
            }

            // 보석 종류 총 개수 == 가지고 있는 보석 종류 개수,
            // 가지고 있는 보석 개수 < 이전 최소 보석 개수일 때
            if(set.size() == map.size() && len > q.size()) {
                len = q.size();
                answer[0] = index + 1;
                answer[1] = index + len;
            }

        }


        return answer;
    }
}