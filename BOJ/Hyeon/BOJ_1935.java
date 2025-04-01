package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ('A' <= c && c <= 'Z') {
                stack.push((double) arr[c - 'A']);
            } else {
                double d1 = stack.pop();
                double d2 = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(d2 + d1);
                        break;
                    case '*':
                        stack.push(d2 * d1);
                        break;
                    case '-':
                        stack.push(d2 - d1);
                        break;
                    case '/':
                        stack.push(d2 / d1);
                        break;
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
// S3 후위 표기식 스택
// 쉽게 풀었지만 접근을 고려해야된다. 실수의 연산이고 표기식 연산결과를 스택에서 넣었다 연산했다 하기 때문에
// 스택을 Doulbe 형으로 만든다.
// 그리고 문자의 경우 이를 정수와 매치되어서 입력값을 받아 알파벳의 정수값을 얻고 입력값이 알파벳이면
// 실수형 형변환과 문자 - 'A' 를 통해서 값을 구한것을 스택에 넣는다.