class Solution {
    public String solution(String new_id) {
        
        StringBuilder sb = new StringBuilder(new_id);
        
        // 1�ܰ�: �빮�� -> �ҹ���
        new_id = new_id.toLowerCase();
        sb = new StringBuilder(new_id);
        
        // 2�ܰ�: �Ұ����� ���� ����
        for(int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '.' || c == '-' || c == '_') continue;
            sb.deleteCharAt(i--);
        }
        
        // 3�ܰ�: ��ħǥ ����
        for(int i = 0; i < sb.length()-1; i++) {
            if(sb.charAt(i) == '.' && sb.charAt(i+1) == '.') {
                sb.deleteCharAt(i+1);
                i--;
            }
        }
        
        // 4�ܰ�: ó��, ������ ��ħǥ ����
        while(sb.length() > 0 && sb.charAt(0) == '.') sb.deleteCharAt(0);
        while(sb.length() > 0 && sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
        
        // 5�ܰ�: �� ���ڿ��̸� 'a' �߰�
        if(sb.length() == 0) sb.append('a');
        
        // 6�ܰ�: 16�� �̻��̸� �� �̻� �ڸ��� ��ħǥ ����
        if(sb.length() >= 16) {
            sb.setLength(15);
            while(sb.length() > 0 && sb.charAt(sb.length()-1) == '.') sb.deleteCharAt(sb.length()-1);
        }
        
        // 7�ܰ�: 2�� ���϶�� ������ ���� �߰�
        if(sb.length() <= 2) {
            while(sb.length() != 3) sb.append(sb.charAt(sb.length()-1));
        }
        
        return sb.toString();
    }
}