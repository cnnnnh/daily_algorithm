import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // 완주자 명단
        for(String key : completion) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        // 참가자 명단 탐색
        for(String name : participant) {
        	// 완주자 명단에 있을 때
            if(map.containsKey(name)) {
                if(map.get(name) == 1) map.remove(name);
                else map.put(name, map.get(name) - 1);
            }
            // 완주자 명단에 없을 때
            else return name;
        }
        
        return "";
    }
}