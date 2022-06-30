package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.HashMap;

public class Baek_1935 {
    public static double compute(double num1, double num2, char op) {
        switch (op)
        {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '/':
                return num1 / num2;
            case '*':
                return num1 * num2;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Double> hsm = new HashMap<>();
        Stack<Double> operand = new Stack<>();
        int opndNum = Integer.parseInt(br.readLine());
        String exp = br.readLine();
        
        double num;
        char ch;

        for (int i = 65; i < (65 + opndNum); i++) {    // i는 'A'부터 ~ b, c, d 순으로
            num = (double)Integer.parseInt(br.readLine());
            hsm.put((char)i, num);
            // i를 key로 갖는 요소 하나씩 생성
        }

        for (int i = 0; i < exp.length(); i++) {
            ch = exp.charAt(i);

            switch(ch)
            {
                case '+':
                case '-':
                case '*':
                case '/':
                    if (operand.empty())
                        break;

                    double num2 = operand.pop();
                    double num1 = operand.pop();
                    operand.push(compute(num1, num2, ch));
                    break;
                default:
                    operand.push(hsm.get(ch));
                    // key를 이용해 알파벳에 부여한 수를 알 수 있다.
            }
        }

        System.out.printf("%.2f\n", operand.pop());
    }
}