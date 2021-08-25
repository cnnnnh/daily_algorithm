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
            int left = 0;
            int right = list.size() - 1;
            boolean flag = false;
            
            while(left <= right) {
                int mid = (left + right) / 2;
                
                if (list.get(mid) == x) {
                    flag = true;
                    break;
                }
                else if (list.get(mid) < x) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
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
    
}