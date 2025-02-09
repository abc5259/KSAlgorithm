package BOJ.Hyeon.feb;

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
