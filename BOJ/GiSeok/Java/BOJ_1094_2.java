/**
 * 1094 - 막대기 [성공|00:19:23]
 * 실버5, 비트마스킹
 * 
 * 아까는 구현으로 주어진 조건 그대로 문제를 풀었지만 이번에는 비트마스킹을 활용하였다.
 * 64를 계속 반으로 나누어 주어진 수를 표현하는 방법인데,
 * 64 32 16 8 4 2 1가 적어도 1개씩은 존재하므로 1~64까지 모든 수를 표현할 수 있다.
 * 그럼 이진법으로 x를 표현하여 1의 갯수만 세어주면 답이 나온다. 왜냐면 16 16 두 개가 되어도 무조건 하나의 16을 반으로 쪼개거나 버리기 때문이다.
 * 즉, 같은 수가 두 개 나오는 경우가 없다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1094_2 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int ret = 1;

        while (x != 1) {
            if ((x & 1) >= 1) ret++;
            x/=2;
        }

        System.out.println(ret);
    }
}
