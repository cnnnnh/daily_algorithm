import java.util.*;

// �� �� �� .

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
    	// �� ������ ��
        if(cnt == words.length) {
            return;
        }
        
        for(int i = 0; i < visited.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            // Ÿ�� �ܾ ������ ��
            if(word.equals(str)) {
                min = Math.min(min, cnt);
                return;
            }
            // �ܾ� ��ȯ�� ������ �� (���ڿ� �ϳ��� �ٸ� ��)
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