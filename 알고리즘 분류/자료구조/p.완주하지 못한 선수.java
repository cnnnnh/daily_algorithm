import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // ������ ���
        for(String key : completion) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        // ������ ��� Ž��
        for(String name : participant) {
        	// ������ ��ܿ� ���� ��
            if(map.containsKey(name)) {
                if(map.get(name) == 1) map.remove(name);
                else map.put(name, map.get(name) - 1);
            }
            // ������ ��ܿ� ���� ��
            else return name;
        }
        
        return "";
    }
}