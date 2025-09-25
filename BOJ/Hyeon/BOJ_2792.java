package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2792 {
    static int N, M;
    static int[] jewels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        jewels = new int[M];

        int max = 0;
        for (int i = 0; i < M; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, jewels[i]);
        }

        System.out.print(lowerBound(max));
    }

    static int lowerBound(int var) {

        int lo = 0;
        int hi = var;

        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;
            if (check(mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi;
    }

    static boolean check(int var) {
        long cnt = 0;

        for (int i = 0; i < M; i++) {
            cnt += jewels[i] / var;
            if (jewels[i] % var != 0) {
                cnt++;
            }
        }
        return cnt <= N;
    }
}
// S1 보석 상자 이분탐색
// 일단 문제에서 구하고자 하는건 질투심이었고 질투심은 최대 보석의 갯수이다
// 그래서 lo 와 hi 의 범위를 질투심의 범위인 0부터 가장 큰 max 질투심으로 지정한다
// 익스클루시브 불가능한 값인 lo 와 가능한 값 인클루시브 인 hi 를 둔다.시작점으
// 그리고 아이들에게 나눠줘서 이게 N보다 작거나 같은 사람에게 나눠줘야된다. 왜냐하면 한명도 못 받을 수도 있기 때문이다
// 단순하게 이분 탐색을 접근할 떄 항상 FFFF...TTTT 를 통해서 lowerBound를 사용했기에 hi 의 인덱스를 질투심으로 판단한다.
// 그래서 check 라는 메소드를 통해서 cnt 의 갯수를 구한다 이때 이게 참일 경우 hi 는 mid 로 해서 왼쪽 탐색으로 이어나가고
// 아니면 lo 로 오른쪽 탐색으로 진행한다.