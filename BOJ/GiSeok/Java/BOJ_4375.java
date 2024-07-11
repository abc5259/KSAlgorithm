/**
 * 4375 - 1 [실패|01:09:02]
 * 정수론, 실버3
 * 
 * 발상의 전환이 필요한 문제다.
 * 무조건 n을 곱해서 1, 11, 111, 1111, ... 을 만들려고 했던게 문제였다.
 * 1, 11, 111, 1111, ... 을 n으로 나누는 방법으로도 풀 수 있다!!!
 * 그리고 처음 BigInteger를 접해서 사용에 어색했음.
 * 문제에서 몇 번을 입력받는지 알 수 없어서 첫 문자가 반복횟수가 되는 줄 알고 계속 삽질했던 것도 문제.
 * 이 문제처럼 '입력은 여러 개의 테스트 케이스로 이루어져 있다.'와 같이 특정 변수나 횟수를 말하지 않는다면,
 * 정말 여러 번 입력받을 수 있도록 구성해야겠다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_4375 {
    // 2, 5로 나누어 떨어지지 않는 정수 n (1 <= n <= 10000)
    // n % 2 != 0 && n % 5 != 0
    // 각 자릿수가 모두 1로만 이루어진 n의 배수 중 가장 작은 수의 자릿수를 구하는 것
    // 3 -> 6 -> 9 -> ... -> 111 (37)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s;
        while ((s = br.readLine()) != null) {
            BigInteger n = new BigInteger(s);
            BigInteger init = new BigInteger("1");
            while (!init.mod(n).equals(BigInteger.valueOf(0)))
                init = init.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(1));

            System.out.println(init.toString().length());
        }
    }
}
