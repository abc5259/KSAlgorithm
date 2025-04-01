package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] liquids = new int[N];
        for (int i = 0; i < N; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N - 1; i++) {
            int sum = lowerBound(liquids, i);
            if (Math.abs(min) > Math.abs(sum)) {
                min = sum;
            }
        }
        System.out.println(min);
    }

    private static int lowerBound(int[] arr, int idx) {
        int lo = idx + 1;
        int hi = arr.length - 1;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] >= -arr[idx]) {
                hi = mid;
            } else {
                lo = mid;

            }
        }

        int sum1 = arr[idx] + arr[lo];
        int sum2 = arr[idx] + arr[hi];

        return (Math.abs(sum1) < Math.abs(sum2)) ? sum1 : sum2;
    }
}

// G5 용액 합성하기 이분탐색
// 이분탐색해서 lowerBound 의 타겟과 같거나 작은 값과 그보다 1개 작은 값을 이용해서 lo 와 hi를 통해서 연산한다
// 인덱스 별로 값을 리턴하고 그걸 절대값 비교해서 반환한다.