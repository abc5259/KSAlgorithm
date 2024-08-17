/**
 * 15926 - 현욱은 괄호왕이야!! [실패]
 * 골드3, 스택
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_15926 {
    // 시간제한 2초, 메모리제한 512MB
    // 올바른 괄호 문자열 조건
    // 1. () 는 올바른 괄호 문자열이다.
    // 2. 어떤 문자열 x가 올바른 괄호 문자열이면 (x)도 올바른 괄호 문자열이다.
    // 3. 어떤 문자열 x, y가 올바른 괄호 문자열이면 xy도 올바른 괄호 문자열이다.
    // 친구로부터 굉장히 긴 괄호 문자열을 받음.
    // 이를 적절히 잘라 가장 긴 올바른 괄호 문자열을 만들고 길이를 출력

    // 스택에 담아가며 올바른 괄호 문자열일 때까지 cnt 값 1개씩 증가하다가
    // 아니게 되면 스택 비우고 다시 cnt 갱신?

    static int ret = 0;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        ArrayDeque<Integer> stk = new ArrayDeque<>();
        d = new int[n];

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == '(') stk.push(i);
            else {
                if (!stk.isEmpty())
                    d[i] = d[stk.pop()] = 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (d[i] == 1) { sum += d[i]; ret = Math.max(sum, ret); }
            else sum = 0;
        }

        System.out.println(ret);
    }
}
