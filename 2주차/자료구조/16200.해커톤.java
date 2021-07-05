import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        
        int n = Integer.parseInt(st.nextToken());
        int team = 0;
        int cnt = 0;
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            list.add(x);
        }
        
        Collections.sort(list);
        
        int target = list.get(0);
        
        for (int i = 0; i < n; i++) {
        	if (cnt == 0) {
        		target = list.get(i);
        	}
            if (target == cnt + 1) {
                team++;
                cnt = 0;
            }
            else {
                cnt++;
            }
        }
        
        if (cnt != 0) team++;
        
        bw.append(String.valueOf(team));
        bw.flush();
        br.close();
        bw.close();
        
    }
}