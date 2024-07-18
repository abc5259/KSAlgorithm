/**
 * 9012 - 괄호 [성공|00:06:42]
 * 실버4, 스택, 시도1
 * 
 * 간단한 괄호 짝 찾기 문제
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_9012 {
    // 시간제한 1초, 메모리제한 128MB
    // '괄호 문자열': 두 개의 괄호 ()로 구성된 문자열
    // 괄호의 모양이 올바르게 구성된 문자열을 올바른 괄호 문자열.
    // 괄호의 쌍이 맞는지 확인하는 문제 == 스택.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            ArrayDeque<Character> stk = new ArrayDeque<>();

            String ps = br.readLine();
            for (int i = 0; i < ps.length(); i++) {
                char p = ps.charAt(i);

                if (!stk.isEmpty() && stk.peek() == '(' && p == ')') stk.removeLast();
                else stk.addLast(p);
            }

            if (stk.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
