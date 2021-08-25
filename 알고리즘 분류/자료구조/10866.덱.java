import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        
        int n = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) {
                case "push_front" : 
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back" :
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front" :
                    bw.append(dq.isEmpty() ? "-1" : String.valueOf(dq.pollFirst()));
                    bw.newLine();
                    break;
                case "pop_back" :
                    bw.append(dq.isEmpty() ? "-1" : String.valueOf(dq.pollLast()));
                    bw.newLine();
                    break;
                case "size" :
                    bw.append(String.valueOf(dq.size()));
                    bw.newLine();
                    break;
                case "empty" :
                    bw.append(dq.isEmpty() ? "1" : "0");
                    bw.newLine();
                    break;
                case "front" :
                    bw.append(dq.isEmpty() ? "-1" : String.valueOf(dq.peekFirst()));
                    bw.newLine();
                    break;
                case "back" :
                    bw.append(dq.isEmpty() ? "-1" : String.valueOf(dq.peekLast()));
                    bw.newLine();
                    break;
            }
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}