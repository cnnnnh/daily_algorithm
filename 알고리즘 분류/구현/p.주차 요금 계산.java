import java.util.*;

class Solution {
    
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        StringTokenizer st = null;
        String timeStr = null, number = null;
        int time = 0;
        
        for(int i = 0; i < records.length; i++) {
            st = new StringTokenizer(records[i]);
            timeStr = st.nextToken();
            time = convertTime(timeStr.split(":"));
            number = st.nextToken();
            
            if(!map.containsKey(number)) {
                map.put(number, new ArrayList<>());
            }
            map.get(number).add(time);
           
        }
        
        int[] answer = new int[map.size()];
        int index = 0, cost = 0, result = 0;
        ArrayList<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        
        for(String key : keys) {
            result = 0;
            cost = 0;
            if(map.get(key).size() % 2 != 0) map.get(key).add(23*60+59);
            ArrayList<Integer> list = map.get(key);
            for(int i = 0; i < list.size(); i+=2) {
                result += (list.get(i+1) - list.get(i));
            }
            result -= fees[0];
            cost += fees[1];
            if(result <= 0) {
                answer[index++] = cost;
                continue;
            }
            result = (int)Math.ceil((double)result / (double)fees[2]);
            cost += (fees[3] * result);
            answer[index++] = cost;
        }
        
        return answer;
    }
    
    public static int convertTime(String[] str) {
        return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
    }
}