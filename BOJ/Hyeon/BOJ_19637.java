package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19637 {
    static int N;
    static Title[] titles;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        titles = new Title[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            titles[i] = new Title(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(br.readLine());
            sb.append(lowerBound(tmp)).append("\n");
        }
        System.out.println(sb);
    }

    static String lowerBound(int tmp) {
        int lo = -1;
        int hi = N - 1;

        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;

            if (check(mid, tmp)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return titles[hi].name;
    }

    static boolean check(int idx, int tmp) {
        return tmp <= titles[idx].power;
    }


    static class Title {
        String name;
        int power;

        public Title(String name, int power) {
            this.name = name;
            this.power = power;
        }
    }
}
// S3 IF문 좀 대신 써줘 이분탐색
// 25분
// 일단 먼저 입력값이 10만, 10만이길래 탐색할 경우 100억이라 이분탐색을 도입
// 그런데 N개의 입력값이 타입이 다르길래 배열로 하려다가 클래스로 따로 뺏다
// 그다음에 이분탐색 결정 조건을 하기위해 만약 주어진 title의 mid 값보다 작거나 같다가 참일 경우
// 왼쪽에 더 참이잇겠다 이런 느낌이라서 FFFF TTTT 구조라고 생각해서 lowerBound를 구현했다
// 그리고 check 함수를 따로 빼서 대소 비교를 실행했고
// 그러니 가장 첫번째 T를 구하기 위해서 lo를 익스클루시브 hi 를 인클루시브로 범위를 조정하여
// hi를 인덱스로 가지는 문자열을 리턴하였다.