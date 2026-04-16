package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1557 {
    static final int MAX = 45_000;
    static int[] mobius;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long K = Long.parseLong(br.readLine());

        mobius = new int[MAX + 1];

        mobius[1] = 1;

        for (int i = 1; i <= MAX; i++) {
            if (mobius[i] != 0) {
                for (int j = i * 2; j <= MAX; j += i) {
                    mobius[j] -= mobius[i];
                }
            }
        }

        long lo = 0;
        long hi = Integer.MAX_VALUE;

        while (lo + 1 < hi) {
            long mid = lo + (hi - lo) / 2;

            if (getSquareFreeCount(mid) < K) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        System.out.println(hi);
    }

    static long getSquareFreeCount(long x) {
        long cnt = 0;

        for (long i = 1; i * i <= x; i++) {
            cnt += mobius[(int) i] * (x / (i * i));
        }
        return cnt;
    }
}
// D5 제곱 ㄴㄴ 이분탐색
// ㅋㅋ 답지 보고 이분탐색 접근하긴했는데 뫼비우스가 좀 에바
// FFFF TTTT 구조로 가장 작은 hi 반환