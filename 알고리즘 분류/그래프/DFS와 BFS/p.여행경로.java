import java.util.*;

// 다시 풀어볼 것!

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
        
        dfs("", "ICN", 0);
        
        return answer;
    }
    
    public static void dfs(String start, String end, int cnt) {
        if(flag) return;
        
        if(cnt == list.size()) {
            airport[cnt] = end;
            answer = airport;
            flag = true;
            return;
        }
        
        for(int i = 0; i < list.size(); i++) {
            Ticket t = list.get(i);
            if (!visited[i] && t.start.equals(end)) {
                visited[i] = true;
                airport[cnt] = end;
                dfs(end, t.end, cnt+1);
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
            return -1;
        }
    }
}