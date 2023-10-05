package Programmers.JaeHoon.level2;

import java.util.*;

public class 과제_진행하기 {

    class Solution {
        public String[] solution(String[][] plans) {
            String[] answer = new String[plans.length];

            Arrays.sort(plans, (a,b) -> a[1].compareTo(b[1]));

            int N = plans.length;
            Stack<String[]> stack = new Stack<>();
            String[] currWork = plans[0];
            int idx = 0;
            for(int i=1; i<N; i++) {
                int currWorkEndTime = dateToInt(currWork[1]) + Integer.parseInt(currWork[2]);
                int nextWorkStartTime = dateToInt(plans[i][1]);

                if(currWorkEndTime <= nextWorkStartTime) {
                    answer[idx++] = currWork[0];

                    if(currWorkEndTime == nextWorkStartTime) {
                        currWork = plans[i];
                    }else { //시간이 남으면
                        if(!stack.isEmpty()) { //기다리고 있는 과제가 있다면
                            while(!stack.isEmpty()) {
                                String[] task = stack.pop();

                                int endTime = currWorkEndTime + Integer.parseInt(task[2]);
                                if(endTime <= nextWorkStartTime) {
                                    answer[idx++] = task[0];
                                    currWorkEndTime = endTime;
                                }else {
                                    int rest = Integer.parseInt(task[2]) - (nextWorkStartTime - currWorkEndTime);
                                    task[2] = rest + "";
                                    stack.push(task);
                                    break;
                                }
                            }
                            currWork = plans[i];
                        }else { //기다리고 있는 과제가 없다면
                            currWork = plans[i];
                        }
                    }
                }else { //현재 과제가 다 안끝나니 대기 스택에 넣고 현재 작업 바꿔주기
                    int rest = Integer.parseInt(currWork[2]) - (nextWorkStartTime - dateToInt(currWork[1]));
                    currWork[2] = rest + "";
                    stack.push(new String[]{currWork[0],currWork[1],currWork[2]});

                    currWork = plans[i];
                }
            }

            if(idx < N) {
                answer[idx++] = currWork[0];
                while(!stack.isEmpty()) {
                    answer[idx++] = stack.pop()[0];
                }
            }
            return answer;
        }
        public int dateToInt(String date) {
            String[] dateArr = date.split(":");
            return Integer.parseInt(dateArr[0]) * 60 + Integer.parseInt(dateArr[1]);
        }
    }
}
