package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_9020 {
    final static int LIMIT = 10_001;
    static boolean[] prime;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        prime = new boolean[LIMIT];

        Arrays.fill(prime, true);

        prime[1] = false;
        prime[0] = false;

        for (int i = 2; i * i < LIMIT; i++) {
            if (prime[i]) {
                for (int j = i * i; j < LIMIT; j += i) {
                    prime[j] = false;
                }
            }
        }

        sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int tmp1 = n / 2;
            int tmp2 = n - tmp1;

            while (tmp1 > 0 && tmp2 < n) {
                if (prime[tmp1] && prime[tmp2]) {
                    sb.append(tmp1).append(" ").append(tmp2).append("\n");
                    break;
                }
                tmp1--;
                tmp2++;
            }
        }
        System.out.println(sb);
    }
}
// S2 골드바흐의 추측 에라토스테네스의 체
// 20분
// 일단 나는 입력되는 테스트케이스마다 정수 판별을 해서 tmp 의 값을 조절하려고 했었는데
// 생각해보니 그냥 Prime 에 대한 값을 한번에 구하고 나서 테스트케이스로 반복문만 돌리는게
// 시간적으로 효율적이라고 생각했다
// 그래서 에라토스테네스의 체를 통해서 소수를 구하고 prime 이라는 배열에
// O(1) 로 접근하게 하여 값을 구하고 이를 투포인터 처럼 다뤘다.