package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1300 {
    static int N, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        System.out.println(lowerBound());
    }

    static int lowerBound() {
        int lo = 0;
        int hi = k;

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

    static boolean check(int mid) {
        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            cnt += Math.min(N, mid / i);
        }

        return cnt >= k;
    }
}
// G1 K번째 수 이분탐색 파라메트릭 서치
// 45분
// 다시 하면 좋을 문제
// 일단 A 배열이 N * N 크기에 초기화 방식을 알려주었다. 그러나
// N은 10만이라서 배열을 초기화할 수 없었고 이를 초기화 한 값을 B 배열에 오름차순 1차원 배열화 해서
// 여기서 이분탐색 하는게 문제였는데
// 참신한 idea
// 일단 고려할게 k번째 수 즉 k 보다 작거나 같은게 내 앞에 몇개나 있나 이를 이분탐색화 하는것이다
// A 배열로 인해서 만들어질 수 들에 대하여 행 반복문을 통해
// 현재 mid 보다 행에 작은거에 대한 개수가 몇개냐 해서 모든 행의 개수 합을 구햇을 때
// 이게 내가 찾고자 하는 k 의 개수보다 클경우 더 왼쪽으로 탐색해야되고
// 작을 경우 더 오른쪽으로 탐색하는 이분탐색이다
// 즉 FFFF TTTT 구조로 lowerBound 를 사용했다
// 가장 첫번째 T는 내앞에 수들이 본인보다 작거나 같은게 k개나 있다는 소리이다
// 그래서 lo 는 익스클루시브로 0을하고 hi는 k까지로 인클루시브화 했다