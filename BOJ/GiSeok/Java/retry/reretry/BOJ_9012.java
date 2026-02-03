package BOJ.GiSeok.Java.retry.reretry;

import java.io.*;
import java.util.*;

public class BOJ_9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            Deque<Character> stk = new ArrayDeque<>();

            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);

                if (c == '(' || stk.isEmpty()) stk.push(c);
                else {
                    if (stk.peek() == '(') stk.pop();
                    else break;
                }
            }

            if (stk.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
