import java.io.*;
import java.util.*;

// StringTokenizer의 delim VS split
// delim은 포함하는 문자열 내 문자 하나씩을 인식하여 나눔
// split은 정확한 한 문자열만을 나눔

public class Main {
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        
        int tc = Integer.parseInt(br.readLine());
        int N, len;
        boolean flag, error;
        char c;
        String order;
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int T = 0; T < tc; T++) {
        	order = br.readLine();
        	N = Integer.parseInt(br.readLine());
        	flag = false;
        	error = false;
        	st = new StringTokenizer(br.readLine(), "[],");
        	
        	for(int i = 0; i < N; i++) {
        		deque.offerFirst(Integer.parseInt(st.nextToken()));
        	}
        	
        	for(int i = 0; i < order.length(); i++) {
        		c = order.charAt(i);
        		if(c == 'R') {
        			flag = !flag;
        		} else {
        			if(deque.isEmpty()) {
        				error = true;
        				break;
        			}
        			if(flag) {
        				deque.pollFirst();
        			}
        			else {
        				deque.pollLast();
        			}
        		}
        	}
        	
        	if(error) {
        		bw.append("error\n");
        		continue;
        	}
        	
        	len = deque.size();
        	bw.append("[");
        	for(int i = 0; i < len-1; i++) {
        		if(flag) {
        			bw.append(String.valueOf(deque.pollFirst()) + ",");
        		}
        		else {
        			bw.append(String.valueOf(deque.pollLast()) + ",");
        		}
        	}
        	if(len != 0) bw.append(String.valueOf(deque.pollFirst()));
        	bw.append("]\n");
        	
        }
        bw.flush();
        
    }
    	
}