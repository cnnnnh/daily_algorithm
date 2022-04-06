import java.util.*;

/*
 킹갓제너럴 알고리즘 고수님의 도움을 받아 통과!
 정렬 실수... ㅆㄹㄱ ㅈㅂ...
 c++ 하라는 고수님의 영업을 받았다 ㅋㅋㅋㅋㅋ
*/

class Solution {
    
    static ArrayList<Ticket> list;
    static String[] airport, answer;
    static boolean[] visited;
    static boolean flag;
    
    public String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        airport = new String[tickets.length+1];
        answer = new String[tickets.length+1];
        visited = new boolean[tickets.length];
        flag = false;
        
        for(int i = 0; i < tickets.length; i++) {
            list.add(new Ticket(tickets[i][0], tickets[i][1]));
        }
        Collections.sort(list);
        
        dfs("ICN", 0);
        
        return answer;
    }
    
    public static void dfs(String spot, int cnt) {
        airport[cnt] = spot;
        
        if(cnt == list.size()) {
            answer = airport;
            flag = true;
            return;
        }
        
        for(int i = 0; i < list.size(); i++) {
            Ticket t = list.get(i);
            if (!visited[i] && t.start.equals(spot)) {
                visited[i] = true;
                dfs(t.end, cnt+1);
                if(flag) return;
                visited[i] = false;
            }
        }
    }
    
    static class Ticket implements Comparable<Ticket> {
        String start, end;
        
        public Ticket (String start, String end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Ticket t) {
            if(t.start.equals(this.start)) {
                if(t.end.compareTo(this.end) > 0) return -1;
                return 1;
            }
            else if(t.start.compareTo(this.start) > 0) return -1;
            else return 1;
        }
    }
}