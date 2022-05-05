import java.util.*;

/*
 * level 2 인데 왜이렇게 머리가 아프죠 ㅠ_ㅠ
 */

class Solution {
    
    static int num, max;
    static char[] selected;
    static HashMap<Integer, HashSet<Character>> menuMap;
    static HashMap<String, Integer> answerMap;
    static List<Character> list;
    
    public String[] solution(String[] orders, int[] course) {
        num = 0;
        menuMap = new HashMap<>();
        PriorityQueue<String> q = new PriorityQueue<>();
        HashSet<Character> menuSet = new HashSet<>();
        
        for(int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            menuMap.put(i, new HashSet<>());
            for(int j = 0; j < arr.length; j++) {
                menuMap.get(i).add(arr[j]);
                menuSet.add(arr[j]);
            }
        }
        
        list = new ArrayList<>(menuSet);
        Collections.sort(list);
        
        for(int i = 0; i < course.length; i++) {
            max = Integer.MIN_VALUE;
            answerMap = new HashMap<>();
            selected = new char[course[i]];
            combination(0, 0, course[i]);
            // 최대값 추가
            for(String str : answerMap.keySet()) {
                if(answerMap.get(str) == max) q.offer(str);
            }
        }
        
        int index = 0;
        String[] answer = new String[q.size()];
        while(!q.isEmpty()) answer[index++] = q.poll();
        
        return answer;
    }
    
    public static void combination(int start, int cnt, int n) {
        if(cnt == n) {
            int result = checkMenu();
            // 2명 이상의 수요가 있을 때
            if(result >= 2) {
                String str = String.valueOf(selected);
                answerMap.put(str, result);
                max = Math.max(max, result);
            }
            return;
        }
        
        // 조합 생성
        for(int i = start; i < list.size(); i++) {
            selected[cnt] = list.get(i);
            combination(i+1, cnt+1, n);
        }
    }
    
    public static int checkMenu() {
        int cnt = 0;
        boolean flag = false;
        HashSet<Character> set;
        for(int i = 0; i < menuMap.size(); i++) {
            set = menuMap.get(i);
            flag = false;
            // 해당 조합을 포함하고 있는지 확인
            for(int j = 0; j < selected.length; j++) {
                if(!set.contains(selected[j])) {
                    flag = true;
                    break;
                }
            }
            if(!flag) cnt++;
        }
        return cnt;
    }
}