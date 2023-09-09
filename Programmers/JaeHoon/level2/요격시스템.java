package Programmers.JaeHoon.level2;

import java.util.Arrays;

public class 요격시스템 {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a, b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });

        int end = targets[0][1];
        answer++;
        for(int i=1; i<targets.length; i++) {
            if(end <= targets[i][0]) {
                answer++;
                end = targets[i][1];
            }
        }
        return answer;
    }
}
