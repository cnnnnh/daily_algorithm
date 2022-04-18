import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String>map = new HashMap<>();
        StringTokenizer st = null;
        String type = null, id = null, nickname = null;
        int len = record.length;
        
        for(int i = 0; i < record.length; i++) {
            st = new StringTokenizer(record[i]);
            type = st.nextToken();
            if(type.equals("Leave")) continue;
            if(type.equals("Change")) len--;
            id = st.nextToken();
            nickname = st.nextToken();
            map.put(id, nickname);
            
        }
        
        String message = null;
        String[] answer = new String[len];
        int index = 0;
        
        for(String str : record) {
            st = new StringTokenizer(str);
            type = st.nextToken();
            id = st.nextToken();
            
            if(type.equals("Change")) continue;
            
            nickname = map.get(id);
            
            if(type.equals("Enter")) message = nickname + "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.";
            else message = nickname + "´ÔÀÌ ³ª°¬½À´Ï´Ù.";
            
            answer[index++] = message;
            
        }
        
        
        return answer;
    }
}