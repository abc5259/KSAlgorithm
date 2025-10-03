package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6236 {
    static int N, M;
    static int[] available;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        available = new int[N];

        int max = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            available[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, available[i]);
            sum += available[i];
        }

        System.out.print(binarySearch(max, sum));
    }

    static int binarySearch(int min, int sum) {

        int lo = min - 1;
        int hi = sum;

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
        int cnt = 1;

        int tmp = 0;
        for (int i = 0; i < N; i++) {
            if (tmp + available[i] > var) {
                tmp = available[i];
                cnt++;
            } else {
                tmp += available[i];
            }
        }
        return cnt <= M;
    }
}
// S1 용돈 관리 이분 탐색
// 20분
// N이 10만 번 탐색에 M 도 마찬가지라 이분탐색으로 접근 했다.
// 문제를 이해하는 데 좀 오래 걸렸다 한마디로 파라메트릭 서치를 쓰고 싶은데 M번을 맞추기위해
// 다시 넣고 뺀다는 말은 그냥 M 보다 작거나 같아도 ok 다 이거고
// 이게 금액을 설정하는 lo 와 hi 의 범위 설정이 중요했던 문제 같다
// 근데 내가 접근을 할 때 내가 일일 별 가장 많은 액수를 쓰는 만큼은 최소로 인출을 해야되니까 이게
// lo 값이 되어야 하고 그리고 내가 1번밖에 출금을 못한다는 가정이면 모든 금액의 총합을 썻어야 해서 총합이 hi 였다
// 그런데 이게 1번만 인출을 해도 되는 시스템이다 왜냐하면 M 번을 맞춘다 했으니까 그러면
// FFFF TTTT 이다 금액으로 범위를 선정하면 총합도 1 이니까 M 이하면 OK 라 T 일테고 그러면
// lo 를 익스클루시브로 잡아서 -1 해버리고 hi 를 sum 의 값으로 잡는다음에
// hi 를 줄여나가는 식으로 했다
// 그리고 check 에서는 덧셈으로 하는게 안전하다고 해서 저렇게 탐색조건을 만들었다
// 일단 cnt =1 해줘야된다 왜냐하면 처음 받을 때 1이 올라가있어야 되니까 최초 1번 출금