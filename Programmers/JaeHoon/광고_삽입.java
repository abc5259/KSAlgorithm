package Programmers.JaeHoon;

public class 광고_삽입 {
  class Solution {
    public int getSeconds(String time) {
        return Integer.parseInt(time.substring(0,2)) * 3600
            +  Integer.parseInt(time.substring(3,5)) * 60
            +  Integer.parseInt(time.substring(6,8));
    }
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int totalTime = getSeconds(play_time);
        int[] times = new int[100 * 60 * 60];
        for(String log:logs) {
            String[] splitLog = log.split("-");
            int start = getSeconds(splitLog[0]);
            int end = getSeconds(splitLog[1]);
            for(int i=start; i<end; i++) {
                times[i] += 1;
            }
        }
        
        int advTime = getSeconds(adv_time);
        // 답이될 seconds
        int result = 0;
        // 최대 누적 재생시간의 시작시간 idx
        int removeTimeIdx = 0;
        // 최대 누적 재생시간
        long runingTime = 0;
        for(int i=0; i<advTime; i++)
            runingTime += times[i];
        long prevRuningTime = runingTime;
        for(int i=advTime; i<totalTime; i++) {
            long currRuningTime = prevRuningTime - times[removeTimeIdx] + times[i];
            if(currRuningTime > runingTime) {
                runingTime = currRuningTime;
                result = removeTimeIdx + 1;
            }
            prevRuningTime = currRuningTime;
            removeTimeIdx++;
        }
        int hour = result/3600;
        int min = result % 3600 / 60;
        int seconds = result % 3600 % 60;
        
        answer = String.format("%02d:%02d:%02d", hour,min,seconds);
        return answer;
    }
}
}
