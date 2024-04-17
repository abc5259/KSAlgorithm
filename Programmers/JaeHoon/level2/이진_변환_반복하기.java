package Programmers.JaeHoon.level2;

public class 이진_변환_반복하기 {
    class Solution {
        class Result {
            int zeroCnt;
            String str;
            Result(int zeroCnt, String str) {
                this.zeroCnt = zeroCnt;
                this.str = str;
            }
        }
        int cnt = 0;
        public int[] solution(String s) {
            int[] answer = new int[2];
            answer[1] =  solve(s);
            answer[0] = cnt;

            return answer;
        }

        public int solve(String s) {
            cnt++;

            Result result = findZeroAndRemove(s);
            int total = result.zeroCnt;
            int length = result.str.length();
            String binary = Integer.toBinaryString(length);
            if(binary.equals("1")) return total;

            return total + solve(binary);
        }

        public Result findZeroAndRemove(String s) {
            StringBuilder sb  = new StringBuilder();
            int zeroCnt = 0;

            for(int i=0; i<s.length(); i++) {
                if(s.charAt(i) == '0') {
                    zeroCnt++;
                }else {
                    sb.append(s.charAt(i));
                }
            }

            return new Result(zeroCnt, sb.toString());
        }
    }
}
