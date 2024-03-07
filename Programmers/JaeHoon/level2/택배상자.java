package Programmers.JaeHoon.level2;

import java.util.*;

public class 택배상자 {

    class Solution {
        public int solution(int[] order) {
            int answer = 0;
            Queue<Integer> q = new LinkedList<>();
            Stack<Integer> stack = new Stack<>();
            for(int i=1; i<=order.length; i++) {
                q.offer(i);
            }

            int index = 0;
            while(!q.isEmpty() || !stack.isEmpty()) {
                if(!stack.isEmpty() && stack.peek() == order[index]) {
                    stack.pop();
                    index++;
                    answer++;
                }
                else {
                    boolean isOk = false;
                    while(!q.isEmpty()) {
                        int n = q.poll();
                        if(n == order[index]) {
                            answer++;
                            index++;
                            isOk = true;
                            break;
                        }

                        stack.push(n);
                    }
                    if(!isOk) break;
                }
            }

            return answer;
        }
    }
}
