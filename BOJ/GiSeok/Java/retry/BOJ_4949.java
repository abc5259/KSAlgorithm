package BOJ.GiSeok.Java.retry;

// 00:05:34 S4
import java.util.*;
import java.io.*;

public class BOJ_4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String 입력 = br.readLine();
            if (입력.equals(".")) break;

            Deque<Character> stk = new ArrayDeque<>();
            for (int i = 0; i < 입력.length(); i++) {
                char 문자 = 입력.charAt(i);

                if (문자 != '[' && 문자 != ']' && 문자 != '(' && 문자 != ')') continue;

                if (stk.isEmpty()) stk.push(문자);
                else {
                    if (문자 == ']' && stk.peek() == '[') stk.pop();
                    else if (문자 == ')' && stk.peek() == '(') stk.pop();
                    else stk.push(문자);
                }
            }

            if (stk.isEmpty()) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
