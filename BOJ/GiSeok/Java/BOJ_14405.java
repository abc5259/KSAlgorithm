/**
 * 14405 - 피카츄 [성공|00:27:53]
 * 실버5, 문자열, 시도3
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14405 {
    // 시간제한 2초, 메모리제한 512MB
    // 피카츄는 'pi', 'ka', 'chu'를 발음할 수 있다.
    // 문자열 s가 주어졌을 때 'pi', 'ka', 'chu'로 이뤄진 문자열인지아닌지 판단

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        s = s.replaceAll("pi|ka|chu", "");

        if (s.isEmpty()) System.out.println("YES");
        else System.out.println("NO");
    }
}
