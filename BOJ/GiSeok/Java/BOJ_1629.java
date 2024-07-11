/**
 * 1629 - 곱셈 [실패/1:13:24]
 * 분할정복, 실버1
 * 
 * 반씩 줄여가며 계산하는 것까지는 생각하였고 반복문으로 로직을 짜는 부분에서 자꾸 막혔다.
 * 특히, 홀수가 되는 경우를 계산하는 것이 어려워서 계속 막힘..
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {
    // A를 B번 곱한 수를 찾는 문제
    // A, B 모두 int 최대값 2,147,483,647이므로 단순하게 곱하면 20억*20억의 시간복잡도를 가진다.
    // 반씩 줄여가며 계산?

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long ret = 1;
        while (B > 0) {
            if (B % 2 != 0) ret = (ret * A) % C;

            A = (A * A) % C;
            B /= 2;
        }

        System.out.println(ret);
    }
}
