package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] line = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            line[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            lowerBound(lis, line[i]);
        }
        System.out.print(N - lis.size());
    }

    static void lowerBound(List<Integer> lis, int var) {

        int lo = -1;
        int hi = lis.size();

        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;

            if (lis.get(mid) >= var) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        if (hi == lis.size()) {
            lis.add(var);
        } else {
            lis.set(hi, var);
        }
    }
}
// G2 꼬인 전깃줄 이분탐색 LIS
// 일단 주어진 N이 30만이라서 N^2는 불가했다 그래서 이분탐색으로 돌렸다
// 꼬이지 않은 전깃줄을 최대로 남긴다 == 가장 긴 증가하는 부분 수열(LIS)
// 가장 긴 증가하는 부분 수열은 DP 반복문이랑 이분탐색으로 2가지 탐색해서 접근한다
// 그리고 lis 라는 리스트를 통해서 남아있는 가장 긴 수열을 만들어버린다 근데
// 배열을 안쓴 이유는 size 메소드가 편리해서 그랬다.
// 쉽게 풀었다 더 어려운 문제들을 풀어봣었어가지고