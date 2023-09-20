package Programmers.JaeHoon.level3;

public class 연속_펄스_부분_수열의_합 {

    class Solution {
        public long solution(int[] sequence) {
            long answer = 0;
            int N = sequence.length;

            long[] dp1 = new long[N];
            long[] dp2 = new long[N];

            dp1[0] = sequence[0]*1;
            dp2[0] = sequence[0]*-1;
            answer = Math.max(answer,Math.max(dp1[0],dp2[0]));
            for(int i=1; i<N; i++) {
                if(i % 2 != 0) {
                    dp1[i] = Math.max(dp1[i-1] + -sequence[i],-sequence[i]);
                    dp2[i] = Math.max(dp2[i-1] + sequence[i],sequence[i]);
                }else {
                    dp1[i] = Math.max(dp1[i-1] + sequence[i],sequence[i]);
                    dp2[i] = Math.max(dp2[i-1] + -sequence[i],-sequence[i]);
                }
                answer = Math.max(answer,Math.max(dp1[i],dp2[i]));
            }


            return answer;
        }
    }
}
