class Solution {
    public int solution(String s) {
        String cur = null;
        String next = null;
        StringBuilder sb;
        int cur_start, next_end, mid, cnt;
        int answer = s.length();
        
        for(int len = 1; len <= (s.length()/2); len++) {
            cur_start = 0;
            mid = len;
            next_end = mid + len;
            cnt = 1;
            sb = new StringBuilder();
            
            while(next_end <= s.length()) {
                cur = s.substring(cur_start, mid);
                next = s.substring(mid, next_end);
                
                if(cur.equals(next)) cnt++;
                else {
                    if(cnt != 1) sb.append(String.valueOf(cnt));
                    
                    sb.append(cur);
                    cnt = 1;
                }
                
                cur_start = mid;
                mid = next_end;
                next_end = mid + len;
            }
            
            if(cnt != 1) {
                sb.append(String.valueOf(cnt));
                sb.append(cur);
            }
            else sb.append(next);
            
            sb.append(s.substring(mid, s.length()));
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
        
    }
}