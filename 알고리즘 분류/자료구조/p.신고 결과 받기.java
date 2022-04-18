import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, Integer> indexMap = new HashMap<>();
        int[] answer = new int[id_list.length];
        StringTokenizer st = null;
        String from = null, to = null;
        
        for(int i = 0; i < id_list.length; i++) {
            map.put(id_list[i], new HashSet<>());
            indexMap.put(id_list[i], i);
        }
        
        for(int i = 0; i < report.length; i++) {
            st = new StringTokenizer(report[i]);
            from = st.nextToken();
            to = st.nextToken();
            map.get(to).add(from);
        }
        
        
        for(String key : map.keySet()) {
            HashSet<String> user = map.get(key);
            if(user.size() >= k) {
                for(String name : user) {
                    answer[indexMap.get(name)]++;
                }
            }
        }
        
        return answer;
    }
}