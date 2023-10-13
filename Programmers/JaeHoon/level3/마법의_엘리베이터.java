package Programmers.JaeHoon.level3;

public class 마법의_엘리베이터 {
    class Solution {
        String s;
        int answer = Integer.MAX_VALUE;
        public int solution(int storey) {

            boolean isAdd = false;
            s = storey + "";
            dfs(s.length() - 1, false, 0);
            return answer;
        }
        public void dfs(int idx, boolean isAdd, int result) {
            if(idx == -1) {
                if(isAdd) result++;
                answer = Math.min(answer, result);
                return;
            }
            int floor = s.charAt(idx) - '0';

            if(isAdd) floor += 1;

            dfs(idx-1,false,result+floor);
            dfs(idx-1,true,result+10 - floor);
        }
    }
}
