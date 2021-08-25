/*
 * Arrays.sort 를 사용하면 시간초과가 난다.
 * - 해결방법
 * 	  1. Collections.sort (합병 + 삽입 정렬)
 * 		 합병: 최선, 최악 O(nlogn)
 * 		 삽입: 최선 O(n) / 최악 O(n^2)
 * 		 -> O(n) ~ O(nlogn) 보장
 * 	  2. Conting sort
 * 		 boolean 배열 사용
 * 		 -> 시간복잡도가 O(n) 으로 매우 빠른 편
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        
        Collections.sort(list);
        
        for (int i = 0; i < n; i++) {
            bw.append(String.valueOf(list.get(i)) + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}