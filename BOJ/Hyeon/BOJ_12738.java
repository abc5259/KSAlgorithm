package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_12738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> lis = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            lowerBound(lis, A[i]);
        }
        System.out.println(lis.size());
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
// G2 가장 긴 증가하는 부분 수열 3 이분탐색 LIS
// mid 값을 계산하는 부분을 (hi -lo) /2 + lo 로 오버플로우 방지했다
// 비록 100만 이었음에도 수정하였고
// 수열 2 문제와 일치 하게 풀었다
// lowerBound 를 통해서 lis.get(mid) 보다 작거나 같은 값을 봤을 때 hi를 줄여나가는 방식이다
// 이분탐색으로 풀어야만 했던 LIS 풀이이다