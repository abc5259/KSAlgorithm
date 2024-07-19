/**
 * 4949 - 균형잡힌 세상 [성공(반례힌트)|00:41:14]
 * 실버4, 스택, 시도2
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_4949 {
    // 입력이 영문 알파벳, 대괄호, 소괄호로 구성되지만 여기서 괄호 짝이 맞는지를 찾는 문제
    // 결국 알파벳은 무시하고 괄호만 스택에 넣어 짝이 이뤄지는지 보면 됨.
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while (!(s = br.readLine()).equals(".")) {
            ArrayDeque<Character> stk = new ArrayDeque<>();

            for (int i = 0; i < s.length() - 1; i++) {
                char p = s.charAt(i);

                if (!stk.isEmpty() && ((stk.peekLast() == '(' && p == ')') || (stk.peekLast() == '[' && p == ']'))) stk.removeLast();
                else if (p == '(' || p == '[' || p == ')' || p == ']') stk.addLast(p);
            }

            if (stk.isEmpty())
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
