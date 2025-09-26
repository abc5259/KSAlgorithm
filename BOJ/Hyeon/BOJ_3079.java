package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3079 {
    static long M;
    static int[] entrance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        entrance = new int[N];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            entrance[i] = Integer.parseInt(br.readLine());
            min = Math.min(min, entrance[i]);
        }

        System.out.println(lowerBound(min));
    }

    static long lowerBound(int min) {

        long lo = 0;
        long hi = M * min;

        while (lo + 1 < hi) {
            long mid = (hi - lo) / 2 + lo;

            if (check(mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi;
    }

    static boolean check(long time) {
        long cnt = 0;

        for (int duringTime : entrance) {
            cnt += time / duringTime;
        }
        return cnt >= M;
    }
}
// G5 입국심사 이분탐색
// 파라메트릭 서치로 모든 인원 M 명이 심사를 마치는 최소시간을 구해야된다
// 복잡도 계산 :
// M 이 10억 그리고 entrance 원소도 다 10억이라서 10^18까지 됐었다.
// 그럼 최소시간 FFFF TTTT 를 통해서 0부터 M명이 가장 적게 끝내는 출입구에 다 갔을 때를 통해  M * min 으로 범위를 설정한다
// 그래서 이분탐색을 사용하고 lo 부터 hi 까지가 log 10^18 이라서 60이고 N 은 10만 이라 600만으로 가능했다.

// 그리고 check 를 통해 가능한 인원의 수 cnt 를 센다 이거는 최대로 사람을 입국 심사를 한 경우라서 N 이다 시간복잡도는
// 그런데 내가 실수 했다 만약 hi 를 min 으로 안하고 max 로 한다면 entrance가 모두 1이라면
// 10^18 * 10만이 되어버리기 떄문에 이러면 trouble 이된다.
// 그래서 최소값으로 범위지정을 해야된다.