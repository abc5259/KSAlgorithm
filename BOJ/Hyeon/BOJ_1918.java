package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    while (!stack.isEmpty()) {
                        if (stack.peek() != '(') {
                            sb.append(stack.pop());
                        } else {
                            stack.pop();
                        }
                    }
                    break;
                default:
                    sb.append(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    static int priority(char c) {
        if (c == '(') {
            return 0;
        } else if (c == '+' || c == '-') {
            return 1;
        }
        return 2;
    }
}
// G2 후위 표기식
// 처음으로 골드2의 문제를 맞췄다
// 데이터 스트럭쳐에서 스택부터 해결하고자 하고있는데
// 일단 후위표기식의 경우 사칙연산을 제외하면 문자부터 출력되어야 한다.
// 그리고 사칙연산은 스택에 넣어서 필요시에 빼서 출력하기로 한다.
// 까지가 흔하게 아는 후위표기식인데
// 사칙연산과 괄호의 경우 우선순위가 있다. 그래서 우선순위를 리턴받는
// priority 메소드를 통해서 우선순위를 만든다. 근데 닫힌괄호를 만나면 안에있는걸 빼서 하는데
// 닫힌 괄호 만나기 전에는 괄호가 가장 우선순위가 낮다는 점이 가장 중요한 포인트이다 ->  열린괄호가 제일 늦게 나가기 위해
// 열린괄호 이후 -나 + * 등은 괄호의 )거보다 우선순위가 높아서 스택에 그대로 넣어야 한다. == 닫힌괄호가 나와야 팝 할 수 있기 때문
//-----------------------
// trouble shooting
// 스택 특성 EmptyStackException 예외를 생각해서 스택에서 꺼낼 때 항상 스택이 비어있는지를 검사해야한다.