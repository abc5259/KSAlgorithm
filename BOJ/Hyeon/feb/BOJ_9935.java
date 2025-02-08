package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        String bomb = br.readLine();
        int len = bomb.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stack.push(c);
            if (stack.size() >= len) {
                boolean b = true;
                for (int j = 0; j < len; j++) {
                    if (stack.get(stack.size() - len + j) != bomb.charAt(j)) {
                        b = false;
                        break;
                    }
                }
                if (b) {
                    for (int j = 0; j < len; j++) {
                        stack.pop();
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("FRULA");
            return;
        }
        for (Character c : stack) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
// 일단 풀긴했고 1시간뒤에 다시 풀자.