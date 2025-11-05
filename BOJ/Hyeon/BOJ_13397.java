package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13397 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        System.out.print(lowerBound(max));
    }

    static int lowerBound(int max) {
        int lo = -1;
        int hi = max;

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
        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < N; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);

            if (max - min > var) {
                cnt++;
                min = arr[i];
                max = arr[i];
            }
        }
        return cnt <= M;
    }
}
// G4 구간 나누기 2 이분탐색
// 25분
// 일단 이분 탐색의 원리를 통해서 접근 구간 점수의 최댓값을 mid 이하로 가면서 M 개 이하로 구간이 나눠지나?
// mid 가 커지면 T 작아지면 F 니까 이를 결정 조건으로 걸고 FFFF TTTT 조건으로 lowerBound 로직 사용
// 그리고 min 이랑 max 의 크기차이로 check 메소드 생성
