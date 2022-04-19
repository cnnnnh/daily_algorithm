class Solution {
    
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        String str = null;
        
        while(true) {
            if(n < k) {
                sb.append(n);
                str = sb.reverse().toString();
                break;
            }
            sb.append(n % k);
            n /= k;
        }
        
        String[] number = str.split("0");
        int answer = 0;
        
        for(int i = 0; i < number.length; i++) {
            if(number[i].equals("")) continue;
            long num = Long.parseLong(number[i]);
            if(primeNumber(num)) answer++;
        }
        
        return answer;
    }
    
    public static boolean primeNumber(long n) {
        if(n == 1) return false;
        else if (n == 2) return true;
        
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}