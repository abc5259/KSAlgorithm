package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1477 {
    static int N, M, L;
    static int[] restArea;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        restArea = new int[N + 2];
        restArea[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            restArea[i] = Integer.parseInt(st.nextToken());
        }
        restArea[N + 1] = L;

        Arrays.sort(restArea);

        System.out.print(lowerBound());
    }

    static int lowerBound() {
        int lo = 0;
        int hi = L - 1;

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

    static boolean check(int dis) {
        int cnt = 0;

        for (int i = 1; i <= N + 1; i++) {
            cnt += (restArea[i] - restArea[i - 1] - 1) / dis;
        }
        return cnt <= M;
    }
}
// G4 휴게소 세우기 이분탐색
// 34분
// 왜 이분탐색인지 이해가 오래 걸렸음
// trouble -> 그리디 인줄 알고 풀었는데 그러니까 간격이 계쏙해서 바뀌기때문에 1번만 할거 아니면
// 그리디는 아니었던 걸로
// 그래서 휴게소 사이 거리를 이분탐색해서 내가 몇개를 더 넣을 수 있는지 파라메트릭 서치가 필요했다
// check 함수 설계는 다음과 같다 mid 의 거리가 있을 때 M 개의 휴게소가 가능한가? 근데
// 일단 거리이기에 -1 을 해줘야 했고 그다음 가장 처음의 T 를 구하는 FFFF TTTT 문제 이기 떄문에
// lowerBound 로 접근했다.
// 성공했으니 더 좋은 답을 보자 왼쪽을 보자 == hi