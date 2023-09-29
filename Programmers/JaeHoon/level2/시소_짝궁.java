package Programmers.JaeHoon.level2;

public class 시소_짝궁 {
    class Solution {
        public long solution(int[] weights) {
            long answer = 0;
            int[] weightCnt = new int[1001];

            for(int i=0; i<weights.length; i++) {
                weightCnt[weights[i]]++;
            }

            for(int i=0; i<weights.length; i++) {
                weightCnt[weights[i]]--;

                answer += weightCnt[weights[i]];

                int find = weights[i] * 2;
                if(find <= 1000)
                    answer += weightCnt[find];

                if(weights[i] % 2 == 0) {
                    find = weights[i] * 3 / 2;
                    if(find <= 1000)
                        answer += weightCnt[find];

                    find = weights[i] / 2;
                    if(find <= 1000)
                        answer += weightCnt[find];
                }

                if(weights[i] % 4 == 0) {
                    find = weights[i] * 3 / 4;
                    if(find <= 1000)
                        answer += weightCnt[find];
                }

                if(weights[i] % 3 == 0) {
                    find = weights[i] * 4 / 3;
                    if(find <= 1000)
                        answer += weightCnt[find];

                    find = weights[i] * 2 / 3;
                    if(find <= 1000)
                        answer += weightCnt[find];
                }
            }
            return answer;
        }
    }
}
