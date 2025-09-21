package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
    static int[] houses;
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        C = Integer.parseInt(st.nextToken());

        houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        int lo = 1;
        int hi = houses[N - 1] - houses[0] + 1;

        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;

            if (check(mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        System.out.println(lo);
    }

    static boolean check(int dis) {
        int cnt = 1;
        int start = houses[0];

        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - start >= dis) {
                start = houses[i];
                cnt++;
            }
        }
        return cnt >= C;
    }
}
// G4 공유기 설치 이분탐색
// 인덱스로만 계속해서 해왓는데 그냥 가장 짧은 거리인 1이랑 맨 끝집부터 첫집까지의 거리에서 hi+1 로 두고
// 거리별로 이분탐색을 펼쳐서 공유기를 C개 이상깔 쑤있냐가 문제
// 일단 TTTT FFF hi 를 F로 만들기 위해서 + 1 로 둔다.
// 그리고 houses 반복문에서 cnt 의값이 C 만큼되어야 하니까 check 메소드로 점검한다.