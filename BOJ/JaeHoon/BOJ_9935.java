package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935 {
    static String str;
    static String boomStr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        boomStr = br.readLine();
        char lastWord = boomStr.charAt(boomStr.length() - 1);

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c == lastWord) {
                boolean isOk = true;
                Stack<Character> stack2 = new Stack<>();
                int idx = boomStr.length() - 2;
                while (idx >= 0) {
                    if(stack.isEmpty()) {
                        isOk = false;
                        break;
                    }
                    char cur = stack.pop();
                    stack2.push(cur);
                    if(cur != boomStr.charAt(idx)) {
                        isOk = false;
                        break;
                    }
                    idx--;
                }

                if(!isOk) {
                    while (!stack2.isEmpty()) stack.push(stack2.pop());
                    stack.push(c);
                }
            }else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        String result = sb.reverse().toString();
        System.out.println(result.isEmpty() ? "FRULA" : result);
    }
}
