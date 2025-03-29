package BOJ.Hyeon.mar;

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

        int min = 200_000_001;

        for (int i = 0; i < N - 1; i++) {
            int sum = lowerBound(liquids, i);
            if (Math.abs(min) > Math.abs(sum)) {
                min = sum;
            }
        }
        System.out.println(min);
    }

    private static int lowerBound(int[] arr, int idx) {
        int lo = idx;
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

        if (lo == idx) {
            return sum2;
        }
        return (Math.abs(sum1) < Math.abs(sum2)) ? sum1 : sum2;
    }

}
