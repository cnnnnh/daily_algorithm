import java.util.*;

class Solution {
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') sb.append(c);
            else {
                if(c == 'z') {
                    sb.append('0');
                    i += 3;
                }
                else if (c == 'o') {
                    sb.append('1');
                    i += 2;
                }
                else if (c == 't') {
                    if(i + 4 < s.length() && s.substring(i, i+5).equals("three")) {
                        sb.append('3');
                        i += 4;
                    }
                    else {
                        sb.append('2');
                        i += 2;
                    }
                }
                else if (c == 'f') {
                    if(s.substring(i, i+4).equals("four")) {
                        sb.append('4');
                    }
                    else sb.append('5');
                    i += 3;
                }
                else if (c == 's') {
                    if(i + 4 < s.length() && s.substring(i, i+5).equals("seven")) {
                        sb.append('7');
                        i += 4;
                    }
                    else {
                        sb.append('6');
                        i += 2;
                    }
                }
                else if (c == 'e') {
                    sb.append('8');
                    i += 4;
                }
                else {
                    sb.append('9');
                    i += 3;
                }
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}