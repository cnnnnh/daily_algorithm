import java.util.*;

/*
 * 누적합 문제
 */

public class Solution {
    
    public String solution(String play_time, String adv_time, String[] logs) {
        int len = timeConvert(play_time);
        int adLen = timeConvert(adv_time);
        long[] dp = new long[len+1];
        
        for(int i = 0; i < logs.length; i++) {
            String[] arr = logs[i].split("-");
            int start = timeConvert(arr[0]);
            int end = timeConvert(arr[1]);
            // 시작과 끝점 체크
            dp[start]++;
            dp[end]--;
        }
        
        // 시청자 수 구하는 누적합
        for(int i = 1; i < dp.length; i++) {
            dp[i] += dp[i-1];
        }
        
        // 누적 시간 구하는 누적합
        for(int i = 1; i < dp.length; i++) {
            dp[i] += dp[i-1];
        }
        
        long result = dp[adLen-1];
        long max = result;
        int start = 0;
        for(int i = adLen; i < dp.length; i++) {
            result = dp[i] - dp[i-adLen];
            if(max < result) {
                max = result;
                start = (i-adLen+1);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int hour = start / 3600;
        int min = (start % 3600) / 60;
        int sec = (start % 60);
        
        if(hour < 10) sb.append("0" + String.valueOf(hour));
        else sb.append(String.valueOf(hour));
        sb.append(":");
        if(min < 10) sb.append("0" + String.valueOf(min));
        else sb.append(String.valueOf(min));
        sb.append(":");
        if(sec < 10) sb.append("0" + String.valueOf(sec));
        else sb.append(String.valueOf(sec));
        
        return sb.toString();
        
    }
    
    public static int timeConvert(String str) {
        String[] arr = str.split(":");
        return (Integer.parseInt(arr[0]) * 3600) 
            + (Integer.parseInt(arr[1]) * 60) 
            + Integer.parseInt(arr[2]);
    }
}