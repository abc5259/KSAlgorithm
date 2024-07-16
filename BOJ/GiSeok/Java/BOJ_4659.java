/**
 * 4659 - 비밀번호 발음하기 [성공|00:42:16]
 * 실버5, 구현, 시도2
 * 
 * 주어진 조건에 맞게 구현만 하면 되는 문제였다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4659 {
    // '발음이 가능한' 패스워드를 만듦.
    // 높은 품질의 비밀번호 조건
    // 1. 모음(a,e,i,o,u) 하나를 반드시 포함
    // 2. 모음이 3개 혹은 자음이 3개 연속 x
    // 3. 같은 글자가 연속적으로 두 번 x, ee, oo는 예외

    // 입력은 여러 개의 테스트 케이스, 마지막은 테스트 케이스는 end

    static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while (!(s = br.readLine()).equals("end")) {
            boolean flag = true;

            boolean includeVowel = false;
            int lcnt = 0;
            int vcnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (isVowel(s.charAt(i))) { vcnt++; lcnt = 0; includeVowel = true; }
                else { lcnt++; vcnt = 0; }

                if (vcnt >= 3 || lcnt >= 3) { flag = false; break; }

                if (i > 0 && s.charAt(i) == s.charAt(i - 1))
                    if (s.charAt(i) != 'e' && s.charAt(i) != 'o') { flag = false; break; }
            }

            if (!includeVowel) flag = false;

            if (flag)
                System.out.println("<" + s + "> is acceptable.");
            else
                System.out.println("<" + s + "> is not acceptable.");
        }
    }
}
