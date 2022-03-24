import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        
        // 전화번호 넣기
        for(String str : phone_book) {
            set.add(str);
        }
        
        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 1; j < phone_book[i].length(); j++) {
                // 하나씩 잘라서 접두사가 되는 전화번호가 있는지 확인
                if(set.contains(phone_book[i].substring(0, j))) return false;
            }
        }
        
        return true;
    }
}