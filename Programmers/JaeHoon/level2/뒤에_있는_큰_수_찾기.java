package Programmers.JaeHoon.level2;

import java.util.*;

public class 뒤에_있는_큰_수_찾기 {

    class Solution {
        public int[] solution(int[] numbers) {
            int N = numbers.length;
            int[] answer = new int[N];

            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            for(int i=0; i<N; i++) stack1.push(numbers[i]);

            stack2.push(stack1.pop());
            answer[--N] = -1;

            while(!stack1.isEmpty()) {
                int num = stack1.pop();

                while(!stack2.isEmpty() && num >= stack2.peek()) {
                    stack2.pop();
                }

                if(stack2.isEmpty()) answer[--N] = -1;
                else answer[--N] = stack2.peek();

                stack2.push(num);
            }

            return answer;
        }
    }
}
