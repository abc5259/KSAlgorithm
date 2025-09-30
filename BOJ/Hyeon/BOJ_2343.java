package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343 {
    static int N, M;
    static int[] videos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        videos = new int[N];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            videos[i] = Integer.parseInt(st.nextToken());
            sum += videos[i];
            max = Math.max(max, videos[i]);
        }

        System.out.print(lowerBound(max, sum));
    }

    static int lowerBound(int max, int var) {
        int lo = max - 1;
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

    static boolean check(int mid) {
        int cnt = 1;

        int tmp = 0;
        for (int i = 0; i < N; i++) {
            if (tmp + videos[i] > mid) {
                cnt++;
                tmp = videos[i];
            } else {
                tmp += videos[i];
            }
        }
        return cnt <= M;
    }
}
// S1 기타 레슨 이분 탐색
// 와 15분만에 풀었다가 무슨 개고생이냐
// 총 56분.. 많은 반례 와 시도 끝에 결국 풀었네 문제 해석도 어려웠다
// 파라메트릭 서치를 통해서 답이 될 수 있는 값의 범위를 대상으로 이진 탐색하는 건데
// videos 배열 자체를 탐색하는게 아니라 정답인 블루레이의 최소 크기를 찾아야된다
// FFFF TTTT 모델 이니까 lowerBound 였는데
// 범위 설정이 중요했다 hi 는 무조건 총합의 범위가 맞고
// lowerBound 이다 보니 hi 는 인클루시브이고 lo 가 익스클루시브다.
// 그리고 tmp 를 + 로 바꿔서 했다 check 의 로직에 있어서 일단빼고 수습하는거보다
// 증가하기전 공간이 있는지 확인한다.