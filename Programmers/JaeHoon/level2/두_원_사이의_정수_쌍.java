package Programmers.JaeHoon.level2;

import java.util.*;

public class 두_원_사이의_정수_쌍 {

    class Solution {
        public long solution(int r1, int r2) {
            long answer = 0;

            long r2Pow = (long)Math.pow(r2,2);
            long r1Pow = (long)Math.pow(r1,2);
            long side = 0;
            for(int i=0; i<=r2; i++) {
                long y2 = (long)Math.sqrt(r2Pow - (long)Math.pow(i,2));

                long y1 = (long)Math.sqrt(r1Pow - (long)Math.pow(i,2));

                if(Math.sqrt((r1Pow-Math.pow(i,2)))%1==0) side++;

                answer += (y2 - y1) * 4L;
            }
            answer += side*4 - 4;
            return answer;
        }
    }
}
