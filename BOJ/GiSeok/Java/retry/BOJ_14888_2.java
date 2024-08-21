/**
 * 14888 - 연산자 끼워넣기 [성공|00:45:55]
 * 실버1, 완전탐색, 시도1
 */
package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_2 {
    // 시간제한 2초, 메모리제한 512MB
    // 2 <= N <= 11 이기때문에 4개의 연산자를 완탐
    // 4^11 = 약 400만?
    // 그런데 연산자 갯수가 제한되어 있다. 그럼 최대 연산자 10개 중 10개를 뽑는 경우의 수를 구하고,
    // 그것마다 계산 N
    // 11 * 3628800 = 약 4천만..? 될듯

    // 두 번째 방법은 연산자를 뽑아놓고 하지 않고 그냥 한번씩 다 돌려보는 완탐

    // 0 == +, 1 == -, 2 == *, 3 == /

    static int N;
    static int[] A;
    static int[] op = new int[4];

    static int maxret = Integer.MIN_VALUE;
    static int minret = Integer.MAX_VALUE;

    static void permutation(int idx, int sum) {

        if (idx == N-1) {
            maxret = Math.max(maxret, sum);
            minret = Math.min(minret, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                if (i == 0) {
                    permutation(idx + 1, sum + A[idx + 1]);
                } else if (i == 1) {
                    permutation(idx + 1,  sum - A[idx + 1]);
                } else if (i == 2) {
                    permutation(idx + 1,  sum * A[idx + 1]);
                } else {
                    permutation(idx + 1,  sum / A[idx + 1]);
                }
                op[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) op[i] = Integer.parseInt(st.nextToken());

        permutation(0, A[0]);
        System.out.println(maxret);
        System.out.println(minret);
    }
}
