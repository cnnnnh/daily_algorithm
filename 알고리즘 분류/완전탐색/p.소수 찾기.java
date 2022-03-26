import java.util.*;

// 가 보 자 고 !

class Solution {
    
    static int answer;
    static char[] arr, result;
    static boolean[] num, selected, visited;
    static StringBuilder sb;
    
    public int solution(String numbers) {
        answer = 0;
        arr = numbers.toCharArray();
        num = new boolean[10000000];
        num[2] = true;
        visited = new boolean[num.length];
        visited[0] = true;
        visited[1] = true;
        visited[0] = true;
        sb = new StringBuilder();
        
        for(int i = 1; i <= arr.length; i++) { 
            result = new char[i];
            selected = new boolean[arr.length];
            permutation(0, i);
        }
        
        return answer;
    }
    
    public static void permutation(int cnt, int len) {
        if(cnt == len) {
            sb = new StringBuilder();
            for(char c : result) {
                sb.append(c);
            }
            // 이미 방문했으면 안 찾아봄
            if(visited[Integer.parseInt(sb.toString())]) return;
            // 소수일 때
            if(find(Integer.parseInt(sb.toString()))) answer++;
            visited[Integer.parseInt(sb.toString())] = true;
            return;
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(selected[i]) continue;
            selected[i] = true;
            result[cnt] = arr[i];
            permutation(cnt+1, len);
            selected[i] = false;
        }
    }
    
    public static boolean find(int n) {
        if (n == 1) return false;
        else if (n == 2) return true;
        else if (num[n]) return true;
        boolean flag = false;
        
        for(int i = 2; i <= n/2; i++) {
            if(n % i == 0) {
                num[n] = false;
                flag = true;
                break;
            }
        }
        if(!flag) num[n] = true;
        return num[n];
    }
    
}