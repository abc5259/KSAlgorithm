package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ans = new int[10];
        int point = 1; //자릿수
        int start = 1;

        while (start <= n) {
            // n의 끝자리 9로 만들기
            while (n % 10 != 9 && start <= n) {
                cal(n, ans, point); //감소시킨 n도 ans배열에 등장횟수를 증가시킨다.
                n--; //n을 감소시키면서
            }

            if (n < start) {
                break;
            }

            // start의 끝자리 0으로 만들기
            while (start % 10 != 0 && start <= n) {
                cal(start, ans, point);
                start++; //start를 증가시키면서 10으로 만든다.
            }

            start /= 10;
            n /= 10;
            for (int i = 0; i < 10; i++) { //반복되는 등장횟수를 더해준다.
                ans[i] += (n - start + 1) * point;
            }
            point *= 10; //다음 자리수로 넘어가기 위해 * 10을 해준다.
        }

        for (int i = 0; i < 10; i++) { //출력
            System.out.print(ans[i] + " ");
        }

    }
    public static void cal(int x, int[] ans, int point) {
        while (x > 0) {
            ans[x % 10] += point;
            x /= 10;
        }
    }
}
