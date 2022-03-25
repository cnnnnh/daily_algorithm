import java.util.*;

// 똑 똑 해 .

class Solution {
    static int min;
    static String str;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        min = Integer.MAX_VALUE;
        str = new String(target);
        visited = new boolean[words.length];
        
        dfs(begin, 0, words);
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    public static void dfs(String word, int cnt, String[] words) {
    	// 다 돌았을 때
        if(cnt == words.length) {
            return;
        }
        
        for(int i = 0; i < visited.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            // 타겟 단어를 만났을 때
            if(word.equals(str)) {
                min = Math.min(min, cnt);
                return;
            }
            // 단어 변환이 가능할 때 (문자열 하나만 다를 때)
            if(compareWords(word, words[i]) == 1) {
                dfs(words[i], cnt+1, words);
            }
            visited[i] = false;
        }
    }
    
    public static int compareWords(String word1, String word2) {
        int cnt = 0;
        for(int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)) cnt++;
        }
        return cnt;
    }
}