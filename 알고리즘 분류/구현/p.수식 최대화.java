import java.util.*;

/*
 * 또 int 범위 벗어나서 틀림
 * long 안 써서 틀림
 * 킹받음
 */

class Solution {
    
    static long max;
    static Character[] order;
    static boolean[] selected;
    static ArrayList<Long> numberList;
    static ArrayList<Character> operator, operatorList;
    
    public static long solution(String expression) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        numberList = new ArrayList<>();
        operatorList = new ArrayList<>();
        
        char c;
        for(int i = 0; i < expression.length(); i++) {
            c = expression.charAt(i);
            if(c >= '0' && c <= '9') {
                sb.append(c);
            }
            else {
                if(sb.length() > 0) {
                	numberList.add(Long.parseLong(sb.toString()));
                    sb = new StringBuilder();
                }
                set.add(c);
                operatorList.add(c);
            }
        }
    	numberList.add(Long.parseLong(sb.toString()));
        
    	max = 0;
        operator = new ArrayList<>(set);
        order = new Character[set.size()];
        selected = new boolean[order.length];
        
        permutation(0);
        
        return max;
    }
    
    public static void calculate() {
        ArrayList<Long> number = new ArrayList<>();
        ArrayList<Character> operator = new ArrayList<>();
        // list 값 복사
        for(int i = 0 ; i < numberList.size(); i++) number.add(numberList.get(i));
        for(int i = 0 ; i < operatorList.size(); i++) operator.add(operatorList.get(i));
        
    	for(int i = 0; i < order.length; i++) {
    		char c = order[i];
    		// 배열 생성 및 값 복사
        	long[] num = new long[number.size()];
        	char[] op = new char[operator.size()];
        	boolean[] checked = new boolean[number.size()];
        	for(int j = 0; j < num.length; j++) num[j] = number.get(j);
        	for(int j = 0; j < op.length; j++) op[j] = operator.get(j);
    		
        	for(int j = 0; j < op.length; j++) {
    			if(c == op[j]) {
    				switch(c) {
    				case '+':
    					num[j+1] += num[j];
    					break;
    				case '-':
    					num[j+1] = (num[j] - num[j+1]);
    					break;
    				case '*':
    					num[j+1] *= num[j];
    					break;
    				}
    				checked[j] = true;
    				op[j] = '/';
    			}
    		}
    		// 새로운 숫자와 연산자 담기
    		number.clear();
    		operator.clear();
    		for(int j = 0; j < num.length; j++) {
    			if(checked[j]) continue;
    			number.add(num[j]);
    		}
    		for(int j = 0; j < op.length; j++) {
    			if(op[j] == '/') continue;
    			operator.add(op[j]);
    		}
    	}
    	// 최댓값 갱신
    	max = Math.max(max, Math.abs(number.get(0)));
    }
    
    public static void permutation(int cnt) {
        if(cnt == order.length) {
            calculate();
            return;
        }
        for(int i = 0; i < order.length; i++) {
            if(selected[i]) continue;
            selected[i] = true;
            order[cnt] = operator.get(i);
            permutation(cnt+1);
            selected[i] = false;
        }
    }
}