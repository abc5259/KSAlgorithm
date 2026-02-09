package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Deque<String> stk = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (stk.isEmpty() || c == '[' || c == '(') {
                stk.push(String.valueOf(c));
            } else {
                int num = 2;
                if (c == ']') num = 3;

                int sum = 0;
                while (!stk.isEmpty() && !isParentheses(stk.peek()))
                    sum += Integer.parseInt(stk.pop());
                num *= sum == 0 ? 1 : sum;

                if (!stk.isEmpty() && (stk.peek().equals("[") && c == ']' ||
                                       stk.peek().equals("(") && c == ')')) {
                    stk.pop();
                    stk.push(String.valueOf(num));
                    continue;
                }

                // 괄호의 아구가 안 맞았을 때, 따로 안 맞는 괄호를 넣어주지 않아서
                // 이때 걸러주지 않으면 정상 흐름처럼 동작하게 된다.
                System.out.println(0);
                return;
            }
        }

        int ans = 0;
        while (!stk.isEmpty()) {
            if (isParentheses(stk.peek())) {
                ans = 0;
                break;
            }
            ans += Integer.parseInt(stk.pop());
        }

        System.out.println(ans);
    }

    private static boolean isParentheses(String str) {
        return str.equals("[") || str.equals("(") || str.equals("]") || str.equals(")");
    }
}
