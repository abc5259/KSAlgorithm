package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504 {
    static String s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();

        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(c == '(' || c == '[') {
                stack.push(c);
            }
            else if(c == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }

                stack.pop();
            }
            else if(c == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }

                stack.pop();
            }
        }

        if(!stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        System.out.println(solve(-1, s.length()));
    }

    public static int solve(int start, int end) {
        if(start + 1 == end) {
            if(s.charAt(start) == '(') return 2;
            return 3;
        }

        Stack<Character> stack = new Stack<>();

        int prev = start+1;
        int sum = 0;
        for(int i=start+1; i<=end-1; i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[') stack.push(s.charAt(i));
            else {
                stack.pop();
                if(stack.isEmpty()) {
                    sum += solve(prev, i);
                    prev = i+1;
                }
            }
        }

        if(start == -1) return sum;
        if(s.charAt(start) == '(') return sum * 2;
        return sum * 3;
    }
}
