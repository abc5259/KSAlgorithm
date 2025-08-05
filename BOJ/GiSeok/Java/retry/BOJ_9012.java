package BOJ.GiSeok.Java.retry;

// 00:05:39 S4
import java.util.*;
import java.io.*;

public class BOJ_9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            Deque<Character> stk = new ArrayDeque<>();
            for (int j = 0; j < input.length(); j++) {
                if (stk.isEmpty()) stk.push(input.charAt(j));
                else {
                    char 괄호 = input.charAt(j);

                    if (괄호 == ')' && stk.peek() == '(') stk.pop();
                    else stk.push(괄호);
                }
            }

            if (stk.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
