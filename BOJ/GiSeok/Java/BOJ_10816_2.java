/**
 * 10816 - 숫자 카드 2(S4) [O|00:10:29]
 * 이분탐색, 시도3
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_10816_2 {

    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int value = Integer.parseInt(st.nextToken());
            int upperBound = upperBound(n, value);
            int lowerBound = lowerBound(n, value);

            sb.append(upperBound-lowerBound+1).append(" ");
        }
        System.out.println(sb);
    }

    private static int lowerBound(int n, int value) {
        int low;
        int high;
        low = -1;
        high = n;
        while (low + 1 < high) {
            int mid = (low + high) / 2;

            if (nums[mid] >= value) high = mid;
            else low = mid;
        }
        return high;
    }

    private static int upperBound(int n, int value) {
        int low = -1;
        int high = n;
        while (low + 1 < high) {
            int mid = (low + high) / 2;

            if (nums[mid] > value) high = mid;
            else low = mid;
        }
        return low;
    }
}
