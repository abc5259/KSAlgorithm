/**
 * 1285 - 동전 뒤집기 [실패]
 * 골드1, 비트마스킹|완전탐색
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_1285 {
    // 시간제한 6초
    // N^2개의 동전이 N행 N열을 이룸. 일부는 앞면(H)이 위, 나머지는 뒷면(T)이 위

    static int N;
    static int[] coin;
    static ArrayDeque<Integer> stk = new ArrayDeque<>();
    static int ret = Integer.MAX_VALUE;

    static void go(int here) {
        if (here == N) {
            int sum = 0;

            for (int i = 1; i <= (1 << (N-1)); i<<=1) {
                int cnt = 0;
                for (int j = 0; j < N; j++) if ((coin[j] & i) >= 1) cnt++;
                sum += Math.min(cnt, N - cnt);
            }

            ret = Math.min(sum, ret);
            return;
        }

        go(here + 1);
        coin[here] = ~coin[here];
        go(here + 1);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        coin = new int[N];
        for (int i = 0; i < N; i++) {
            String m = br.readLine();
            for (int j = 0; j < N; j++)
                if (m.charAt(j) == 'T') coin[i] += (1 << j);
        }

        go(0);
        System.out.println(ret);
    }
}
