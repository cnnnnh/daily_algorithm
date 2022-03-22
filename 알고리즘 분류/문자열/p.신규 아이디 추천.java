class Solution {
    public String solution(String new_id) {
        
        StringBuilder sb = new StringBuilder(new_id);
        
        // 1단계: 대문자 -> 소문자
        new_id = new_id.toLowerCase();
        sb = new StringBuilder(new_id);
        
        // 2단계: 불가능한 문자 제거
        for(int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '.' || c == '-' || c == '_') continue;
            sb.deleteCharAt(i--);
        }
        
        // 3단계: 마침표 단축
        for(int i = 0; i < sb.length()-1; i++) {
            if(sb.charAt(i) == '.' && sb.charAt(i+1) == '.') {
                sb.deleteCharAt(i+1);
                i--;
            }
        }
        
        // 4단계: 처음, 마지막 마침표 제거
        while(sb.length() > 0 && sb.charAt(0) == '.') sb.deleteCharAt(0);
        while(sb.length() > 0 && sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
        
        // 5단계: 빈 문자열이면 'a' 추가
        if(sb.length() == 0) sb.append('a');
        
        // 6단계: 16자 이상이면 그 이상 자르고 마침표 제거
        if(sb.length() >= 16) {
            sb.setLength(15);
            while(sb.length() > 0 && sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
        }
        
        // 7단계: 2자 이하라면 마지막 문자 추가
        if(sb.length() <= 2) {
            while(sb.length() != 3) sb.append(sb.charAt(sb.length()-1));
        }
        
        return sb.toString();
    }
}