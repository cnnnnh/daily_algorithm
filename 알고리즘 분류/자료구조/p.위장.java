import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        String cloth = null;
        
        for(int i = 0; i < clothes.length; i++) {
            cloth = clothes[i][1];
            if(map.containsKey(cloth)) {
                map.put(cloth, map.get(cloth)+1);
            }
            else {
                map.put(cloth, 1);
                q.offer(cloth);
            }
        }
        
        int result = 0;
        int answer = 1;
        
        while(!q.isEmpty()) {
            cloth = q.poll();
            result = map.get(cloth) + 1;
            answer *= result;
        }
        
        return answer - 1;
    }
}