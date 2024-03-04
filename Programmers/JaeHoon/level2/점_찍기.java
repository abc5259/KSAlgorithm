package Programmers.JaeHoon.level2;

public class 점_찍기 {
    class Solution {
        public long solution(int k, int d) {
            long answer = 0;
            for(int i=0; i<=1000000; i++) {
                int x = i * k;
                if(Math.pow(x,2) > Math.pow(d,2)) break;

                int max = (int)Math.sqrt(Math.pow(d,2) - Math.pow(x,2));
                answer += max / k + 1;
            }

            return answer;
        }
    }
}
