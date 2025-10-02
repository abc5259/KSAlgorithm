package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16401 {
    static int M, N;
    static int[] snack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        snack = new int[N];
        st = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i = 0; i < N; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, snack[i]);
        }

        System.out.print(binarySearch(max));
    }

    static int binarySearch(int max) {
        int lo = 0;
        int hi = max + 1;

        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;

            if (check(mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    static boolean check(int var) {
        long cnt = 0;

        for (int i = 0; i < N; i++) {
            cnt += snack[i] / var;
        }

        return cnt >= M;
    }
}
// S2 과자 나눠주기 이분탐색
// 24분
// 일단 시간복잡도가 둘다 100만이라서 이분탐색으로 당연하게 접근을 했다
// 과자를 X 길이로 잘랐을때 M개 이상 만들 수 있냐?? 라는 결정 문제여서 파라메트릭 서치로 풀었다
// 트러블 슈팅
// 1. cnt는 long 타입이 될 수 있는 거 놓쳤고
// 2. 과자가 사람보다 작을 경우 3명과 2개의 과자 1, 1 이면 lo는 시작이 0되어야 한다
// 이게 지금 TTTT FFFF 문제라서 나는 lowerBound 를 생각했는데 그냥 lo 가 인클루시브이고 hi 가 익스클루시브인데
// 문제 조건상 lo 는 1부터 시작이지만 lo가 0도 되어야 해서 이런 범위이다