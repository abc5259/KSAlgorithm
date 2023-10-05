package Programmers.JaeHoon.level2;

import java.util.*;

public class 광물_캐기 {

    class Solution {
        public int solution(int[] picks, String[] minerals) {


            ArrayList<int[]> arr = new ArrayList<>();

            int sum = 0;
            for(int i=0; i<picks.length; i++) sum += picks[i];

            int idx = 0;
            for(int i=0; i<minerals.length; i+=5) {
                if(idx + 1 > sum) break;
                int diaSum = 0;
                int ironSum = 0;
                int stoneSum = 0;

                for(int j=i; j<Math.min(i+5,minerals.length); j++) {
                    if(minerals[j].equals("diamond")) {
                        diaSum += 1;
                        ironSum += 5;
                        stoneSum += 25;
                    }
                    else if(minerals[j].equals("iron")) {
                        diaSum += 1;
                        ironSum += 1;
                        stoneSum += 5;
                    }
                    else if(minerals[j].equals("stone")) {
                        diaSum += 1;
                        ironSum += 1;
                        stoneSum += 1;
                    }
                }

                arr.add(new int[]{diaSum,ironSum,stoneSum});
                idx++;
            }

            Collections.sort(arr,(a,b) -> b[2] - a[2]);


            int answer = 0;
            for(int i=0; i<arr.size(); i++) {
                if(picks[0] > 0) {
                    answer += arr.get(i)[0];
                    picks[0]--;
                }
                else if(picks[1] > 0) {
                    answer += arr.get(i)[1];
                    picks[1]--;
                }
                else if(picks[2] > 0) {
                    answer += arr.get(i)[2];
                    picks[2]--;
                }
            }
            return answer;
        }

    }
}
