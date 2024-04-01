package Programmers.JaeHoon.level2;

import java.util.*;
import java.util.regex.*;

public class 수식_최대화 {

    class Solution {
        Map<String, Integer> map = Map.of(
                "+", 0,
                "-", 1,
                "*", 2
        );
        int[] priority = new int[3];
        boolean[] isUsed = new boolean[3];
        List<String> infix;
        long answer = 0;
        public long solution(String expression) {

            priority = new int[3];
            infix = tokenize(expression);
            solve(0);
            return answer;
        }
        public void solve(int depth) {
            if(depth == 3) {
                List<String> postfix = toPostfix();
                // System.out.println(postfix);
                Stack<String> stack = new Stack<>();

                for(String s: postfix) {
                    if(s.length() == 1 && (s.charAt(0) == '-' || s.charAt(0) == '+' || s.charAt(0) == '*')) {
                        long a = Long.parseLong(stack.pop());
                        long b = Long.parseLong(stack.pop());
                        long result;
                        if(s.charAt(0) == '-') {
                            result = b - a;
                        }
                        else if(s.charAt(0) == '+') {
                            result = b + a;
                        }else {
                            result = b * a;
                        }
                        stack.push(result+"");
                    }else {
                        stack.push(s);
                    }
                }

                answer = Math.max(answer, Math.abs(Long.parseLong(stack.pop())));

                return;
            }
            for(int i=0; i<3; i++) {
                if(isUsed[i]) continue;
                isUsed[i] = true;
                priority[depth] = i;

                solve(depth + 1);

                isUsed[i] = false;
            }
        }
        public List<String> toPostfix() {
            // System.out.println(Arrays.toString(priority));
            List<String> postfix = new ArrayList<>();
            Stack<String> stack = new Stack<>();

            int index = 0;
            for(String s: infix) {
                if(s.charAt(0) == '-' || s.charAt(0) == '+' || s.charAt(0) == '*') {
                    if(stack.isEmpty()) {
                        stack.push(s);
                    }
                    else if(priority[map.get(stack.peek())] < priority[map.get(s)]) {
                        stack.push(s);
                    }else {
                        while(!stack.isEmpty() && priority[map.get(stack.peek())] >= priority[map.get(s)]) {
                            postfix.add(stack.pop());
                        }
                        stack.push(s);
                    }
                }else {
                    postfix.add(s);
                }
            }

            while(!stack.isEmpty()) {
                postfix.add(stack.pop());
            }

            return postfix;
        }
        public List<String> tokenize(String expression) {
            List<String> tokens = new ArrayList<>();
            Pattern pattern = Pattern.compile("(\\d+|[-+*/])");
            Matcher matcher = pattern.matcher(expression);

            while (matcher.find()) {
                tokens.add(matcher.group());
            }

            return tokens;
        }
    }
}
