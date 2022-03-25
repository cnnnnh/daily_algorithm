import java.util.*;

// 간지나게 서로소 집합으로 풀었음

class Solution {
    static int[] parents;
    public int solution(int n, int[][] computers) {
    	
        make(n);
        
        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers[i].length; j++) {
                if (i == j) continue;
                if(computers[i][j] == 1) union(i, j);
            }
        }
        
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            if(parents[i] == i) answer++;
        }
        return answer;
    }
    
    public static void make(int n) {
        parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }
    
    public static int find(int a) {
        if(parents[a] == a) return a;
        return find(parents[a]);
    }
    
    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
}