package BOJ.Hyeon.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] liquids = new int[N];
        for (int i = 0; i < N; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(liquids);
        int a = 0, b = 0, min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int j = LowerBound(liquids, -liquids[i]);

            if (j == N) j = N - 1;
            if (j == i) {
                if (j > 0) {
                    j--;
                } else if (j < N - 1) {
                    j++;
                }
            }

            if (min > Math.abs(liquids[j] + liquids[i])) {
                min = Math.abs(liquids[j] + liquids[i]);

                if (liquids[j] < liquids[i]) {
                    a = liquids[j];
                    b = liquids[i];
                } else {
                    a = liquids[i];
                    b = liquids[j];
                }
            }
        }
        System.out.println(a + " " + b);
    }

    private static int LowerBound(int[] v, int x) {
        int lo = 0;
        int hi = v.length - 1;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (v[mid] >= x) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return (v[hi] >= x) ? lo : hi;
    }
}
// G5 두 용액