/**
 * 00:08:45 S4
 */
package BOJ.GiSeok.Java.retry;

import java.io.*;
import java.util.*;

public class BOJ_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int ans = 0;
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            for (int idx = 0; idx < input.length(); idx++) {
                char word = input.charAt(idx);

                if (!deque.isEmpty()) {
                    char top = deque.peek();
                    if (top == word) {
                        deque.pop();
                        continue;
                    }
                }

                deque.push(word);
            }

            if (!deque.isEmpty()) {
                deque.clear();
                continue;
            }

            ans++;
        }

        System.out.println(ans);
    }
}
