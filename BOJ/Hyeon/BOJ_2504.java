package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        int sum = 0; // 최종 결과
        int tmp = 1; // 임시로 분배법칙 저장공간

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '(':
                    stack.push(c);
                    tmp *= 2;
                    break;
                case '[':
                    stack.push(c);
                    tmp *= 3;
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        System.out.println(0);
                        return;
                    } else if (str.charAt(i - 1) == '(') {
                        sum += tmp;
                    }
                    stack.pop();
                    tmp /= 2;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        System.out.println(0);
                        return;
                    } else if (str.charAt(i - 1) == '[') {
                        sum += tmp;
                    }
                    stack.pop();
                    tmp /= 3;
                    break;
            }
        }
        if (!stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(sum);
        }
    }
}
// G5 괄호의 값 스택
// 괄호를 통해서 계산하는 건데 +와 *이 섞여있어서 어려웠다. 다른 레퍼런스를 참고해서 분배법칙을 통한 것을 알게되었다.
// Logic
// (([[]])) 케이스의 경우 정답은 36이다 다만 ()()[][]이게 다 곱해져있는거라고 생각하면된다. 그래서
// 닫힌괄호가 만약 문자열의 이전 stack과 상관없이 문자열의 앞에 것과 세트면 그때 분배법칙한 수를 계산하면된다.
// tmp라는 임시변수를 활용해서 분배법칙의 곱을 가져가면된다.