package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4158_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            int[] sang = new int[N];

            for (int i = 0; i < N; i++) {
                sang[i] = Integer.parseInt(br.readLine());
            }

            int cnt = 0;
            for (int j = 0; j < M; j++) {
                int young = Integer.parseInt(br.readLine());
                if (lowerBound(sang, young)) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static boolean lowerBound(int[] sang, int young) {
        int lo = -1;
        int hi = sang.length - 1;

        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;

            if (check(sang[mid], young)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return sang[hi] == young;
    }

    static boolean check(int res, int var) {
        return res >= var;
    }
}
// S5 CD 이분탐색
// 10분
// 또 다른 풀이 일단
// 오름차순, N 과 M이 100만 , 중복 없음 등의 정보를 통해서 이분탐색과 유사하다고 판단
// 그래서 일단 문제에서 상근이를 배열로 만들어서 선언하고 선영이를 M 번 해서 탐색을 하려고 한다
// 또 이분탐색이면 결정 조건이 있어야 하는데 작거나 같다라는 lowerBound의 아이디어가 생각나서 만약 작거나 같아서
// hi라는 인덱스 값이 떨어지면 이때 sang[hi] 가 처음에 입력된 young 의 값과 일치하면 같은 숫자인거고
// 일치 하지 않으면 범위만 일치했다고 판단하면 되기에 이분탐색 사용