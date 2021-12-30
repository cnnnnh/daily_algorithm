import java.io.*;
import java.util.*;

public class Main {
	
	// 버튼 고장 여부
	static boolean[] button;
	
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int num = Integer.parseInt(st.nextToken());
    	int n = Integer.parseInt(br.readLine());
    	
    	button = new boolean[10];
    	
    	// 고장난 버튼이 있을 때만 입력 받기
    	if (n != 0) {
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < n; i++) {
        		button[Integer.parseInt(st.nextToken())] = true;
        	}
    	}
    	
    	// 초기 채널이 100이므로 이렇게 setting
    	int answer = Math.abs(num - 100);
    	
    	// 버튼을 눌러서 만들 수 있는 수의 범위
    	for (int i = 0; i < 1000000; i++) {
    		// 몇 번의 숫자 버튼을 눌러서 i를 만들 수 있는가?
    		int btn = touchButton(i);
    		// 숫자 버튼만으로도 i를 만들 수 있을 때
    		if (btn > 0) {
    			// i에서 num이 되기 위한 +- 횟수
    			int temp = Math.abs(i - num);
    			// 최솟값 갱신
    			if (answer > btn + temp) {
    				answer = btn + temp;
    			}
    		}
    	}
    	
    	System.out.println(answer);
    	
    }
    
    private static int touchButton(int n) {
    	int cnt = 0;
    	
    	// 숫자가 0일 때
    	if (n == 0) {
    		if (button[0]) return 0;
    		return 1;
    	}
    	
    	while(n > 0) {
    		// 해당 숫자가 고장났을 때
    		if (button[n%10]) return 0;
    		// 해당 숫자를 누를 수 있을 때
    		cnt++;
    		n /= 10;
    	}
    	return cnt;
    }
    
}