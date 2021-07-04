import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int T = Integer.parseInt(st.nextToken());
        
        for (int tc = 0; tc < T; tc++) {
            String str = br.readLine();
            int n = Integer.parseInt(br.readLine());
            boolean flag = true;
            boolean error = false;
            Deque<Integer> dq = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine(), "[],");
            for (int i = 0; i < n; i++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'R') {
                    flag = !flag;
                }
                else {
                    if (dq.isEmpty()) {
                        error = true;
                        break;
                    }
                    else {
                        if (flag) {
                            dq.pollFirst();
                        }
                        else {
                            dq.pollLast();
                        }
                    }
                }
            }
            if (error) {
                bw.append("error\n");
            }
            else {
                bw.append("[");
                while(!dq.isEmpty()) {
                    if (flag) {
                        bw.append(String.valueOf(dq.pollFirst()));
                    }
                    else {
                        bw.append(String.valueOf(dq.pollLast()));
                    }
                    if (!dq.isEmpty()) {
                        bw.append(",");
                    }
                }
                bw.append("]\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}