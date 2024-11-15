/**
 * 1920 - 수 찾기(S4) [O|00:07:41]
 * 이분탐색, 시도5
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_2 {

    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(A);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int value = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(n, value));
        }
    }

    private static int binarySearch(int n, int value) {
        int low = -1;
        int high = n;
        while (low + 1 < high) {
            int mid = (low + high) / 2;

            if (A[mid] > value) high = mid;
            else low = mid;
        }

        if (low == -1 || A[low] != value)
            return 0;
        else
            return 1;
    }
}