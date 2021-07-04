import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;
        
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            int idx = list.indexOf(x);
            int mid = 0;
            if (list.size() % 2 == 0) {
                mid = list.size() / 2 - 1;
            }
            else {
                 mid = list.size() / 2;
            }
            if (mid >= idx) {
                for (int j = 0; j < idx; j++) {
                    list.addLast(list.get(0));
                    list.removeFirst();
                    cnt++;
                }
            }
            else {
            	for (int j = 0; j < list.size() - idx; j++) {
                    list.addFirst(list.get(list.size() -1));
                    list.removeLast();
                    cnt++;
                }
            }
            list.removeFirst();
        }
        
        bw.append(String.valueOf(cnt));
        bw.flush();
        br.close();
        bw.close();
        
    }
}