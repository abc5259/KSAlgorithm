package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20033 {
    static int N;
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        height = new int[N];

        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch());
    }

    static int binarySearch() {
        int lo = 1;
        int hi = N + 1;

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

    static boolean check(int h) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (height[i] >= h) {
                cnt++;
            } else {
                cnt = 0;
            }
            if (cnt >= h) {
                return true;
            }
        }
        return false;
    }
}
// G4 Square, Not Rectangle 이분탐색
// 20분
// 그냥 편하게 풀었다. 결정 문제 내가 정사각형이 되냐 안되냐에 대한 그리고 입력값이 N log N 로
// 30만 * log 30만이었다 그래서 시간초과에 대해서 고려할 때 이분탐색 사용
// 왜냐하면 1이라는 높이는 무조건 되는데 N까지도 될 수 있음 그런데 N+1는 안되니까
// TTT FFF 의 틀로 가져갔을 때 lo 가 인클루시브가 되어야 해서 1을 가지고 hi 가 익스클루시브로 N+1로 값을 가진다음에
// 반복문을 이어나가고 T 를 발견하면 mid를 lo 가 가져서 더 오른쪽에 T가 있는지 찾는다.
// check 에 대해서 매번 고민
// 이는 내가 cnt 의 개수로 해서 찾는게 맞는건지 모르겠다 아니면 그리디로 처리하는것도 맞나 싶고