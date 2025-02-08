package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) {
                break;
            }
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                switch (c) {
                    case '(':
                    case '[':
                        stack.push(c);
                        break;
                    case ')':
                        if (!stack.isEmpty() && stack.peek() == '(') {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                        break;
                    case ']':
                        if (!stack.isEmpty() && stack.peek() == '[') {
                            stack.pop();
                        } else {
                            stack.push(c);
                        }
                        break;
                }
            }
            if (stack.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb);
    }
}
// S4 균형잡힌 세상 스택
// 걍 쉽게 풀었다 예전에는 배열로 구현해서 풀고 문자열을 리턴해줫는데
// 이번에는 스택 컬렉션 그냥 사용했다.
// (와 [는 그냥 푸시만 하고 ) 와 ]는 닫혀야 하기때문에 peek 을 통해 비교하고 없으면 그냥 푸시해서
// 마지막에 스택이 비면 yes 안비면 no를 하면된다.