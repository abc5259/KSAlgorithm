package Programmers.JaeHoon.level3;

import java.util.*;
public class 억억단을_외우자 {

    class Solution {
        Point[] dp;
        class Point {
            int n,cnt;
            Point(int n, int cnt) {
                this.n = n;
                this.cnt = cnt;
            }
        }
        public int[] solution(int e, int[] starts) {
            int[] answer = new int[starts.length];
            dp = new Point[e+1];
            for(int i=0; i<=e; i++) dp[i] = new Point(i,0);

            for (int i = 1; i <= e; i++) {
                for (int j = 1; j <= e / i; j++) {
                    dp[i * j].cnt += 1;
                }
            }


            Arrays.sort(dp, (a,b) -> {
                if(a.cnt == b.cnt) return a.n - b.n;
                return b.cnt - a.cnt;
            });

            int index = 0;

            for(int start: starts) {
                for(int i=0; i<=e; i++) {
                    if(dp[i].n >= start) {
                        answer[index++] = dp[i].n;
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
