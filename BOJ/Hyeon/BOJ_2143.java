package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        int ASize = (n + 1) * n / 2;
        int[] ASum = new int[ASize];

        int idx = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                ASum[idx++] = sum;
            }
        }

        idx = 0;
        int BSize = (m + 1) * m / 2;
        int[] BSum = new int[BSize];
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                BSum[idx++] = sum;
            }
        }
        Arrays.sort(ASum);
        Arrays.sort(BSum);

        System.out.print(two(ASum, BSum, T));
    }

    private static long two(int[] arr, int[] brr, int x) {
        int lo = 0;
        int hi = brr.length - 1;
        long cnt = 0;

        while (lo < arr.length && hi > -1) {
            int sum = arr[lo] + brr[hi];

            if (sum == x) {
                long suma = 1, sumb = 1;
                while (lo + 1 < arr.length && arr[lo] == arr[lo + 1]) {
                    suma++;
                    lo++;
                }
                while (hi - 1 >= 0 && brr[hi] == brr[hi - 1]) {
                    hi--;
                    sumb++;
                }
                cnt += suma * sumb;
                lo++;
                hi--;
            } else if (sum > x) {
                hi--;
            } else {
                lo++;
            }
        }
        return cnt;
    }
}
