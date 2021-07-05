import java.util.*;
import java.io.*;

public class Main {
    
    static ArrayList<Integer> list = new ArrayList<>();
    static boolean flag = false;
    
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(list);
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            search(0, n-1, x);
            if (flag) {
                bw.append("1\n");
            }
            else {
                bw.append("0\n");
            }
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    private static void search (int start, int end, int num) {
        if (start > end) {
        	flag = false;
        	return;
        }
        
        int mid = (start + end) / 2;
        
        if (num > list.get(mid)) {
            search(mid+1, end, num);
        }
        else if (num == list.get(mid)) {
            flag = true;
            return;
        }
        else {
            search(start, mid-1, num);
        }
        
    }
}