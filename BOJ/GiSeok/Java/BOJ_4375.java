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
 * 
 * +추가
 * 모듈러 연산 법칙을 사용하면 111을 예로 들자면
 * (((1 * 10 + 1) * 10 + 1) * 10 + 1) % n
 * = ((1 * 10 + 1) * 10 + 1) % n * 10 % n + 1 % n
 * = ((1 * 10 + 1) % n * 10 % n + 1 % n) * 10 % n + 1 % n
 * 즉, 매 init 계산마다 mod n을 해줘도 문제가 되지 않는다는 것이다.
 * 이를 통해 BigInteger가 아닌 int를 사용하고도 문제를 풀 수 있다.
 * 왜냐면 2, 5로 나누어 떨어지지 않는 정수 n 중 가장 큰 값이 9999인데, 9999로 모듈러 연산을 하면
 * init의 값이 9999 이상이 되지 않는다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4375 {
    // 2, 5로 나누어 떨어지지 않는 정수 n (1 <= n <= 10000)
    // n % 2 != 0 && n % 5 != 0
    // 각 자릿수가 모두 1로만 이루어진 n의 배수 중 가장 작은 수의 자릿수를 구하는 것
    // 3 -> 6 -> 9 -> ... -> 111 (37)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while ((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            int init = 1; int ret = 1;
            while (init % n != 0) {
                init = (init * 10 + 1) % n; ret++;
            }

            System.out.println(ret);
        }
    }
}
