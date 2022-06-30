package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Baek_1918 {
    public static int expPriority(char ch) {
        switch (ch)
        {
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        Stack<Character> operation = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        int len = exp.length();
        char ch;

        for (int i = 0; i < len; i++) {
            ch = exp.charAt(i);

            switch (ch)
            {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!operation.empty() && expPriority(ch) <= expPriority(operation.peek()))
                        System.out.print(operation.pop());
                    // 스택에 있는 연산자가 우선순위가 더 크거나 같다면, pop하여 출력

                    operation.push(ch);
                    break;
                case '(':
                    operation.push(ch);
                    break;
                case ')':
                    if (!operation.empty()) {
                        ch = operation.pop();
                        while (ch != '(') {
                            System.out.print(ch);
                            if (operation.empty())
                                break;
                            ch = operation.pop();
                        }
                    }
                    break;
                default:
                    System.out.print(ch);
            }
        }

        while (!operation.empty())
            System.out.print(operation.pop());

        System.out.println("");
        br.close();
    }
}