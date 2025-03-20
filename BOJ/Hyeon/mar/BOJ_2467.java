package BOJ.Hyeon.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] liquids = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(liquids);

        int lo = 0;
        int hi = liquids.length - 1;

        int a = 0, b = 0, min = Integer.MAX_VALUE;
        while (lo < hi) {
            int sum = Math.abs(liquids[lo] + liquids[hi]);

            if (sum < min) {
                min = sum;
                a = liquids[lo];
                b = liquids[hi];
            }

            if (liquids[lo] + liquids[hi] < 0) {
                lo++;
            } else if (liquids[lo] + liquids[hi] > 0) {
                hi--;
            } else {
                break;
            }
        }
        System.out.println(a + " " + b);
    }
}
// G5 용액 투 포인터
// 일단 투 포인터 개념 어제 풀었던 용액과 유사한 문제 근데 이분탐색으로 안 풀었다
// 투 포인터를 써서 양쪽으로 이동하는 방식으로 풀었다.
// 로직은 어제처럼 인덱스를 고려하지 않아도 된다. 왜냐? 어차피 lo와 hi가 범위내에서만 이동하니까.