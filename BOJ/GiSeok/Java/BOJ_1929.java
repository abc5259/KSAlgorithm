/**
 * 1929 - 소수 구하기(S3/에라토스테네스의 체) [O|00:15:46]
 * 시도3
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] nums = new int[1000001];
        for (int i = 2; i < 1000001; i++) nums[i] = i;

        for (int i = 2; i <= 1000000; i++) {
            if (nums[i] == 0) continue;

            for (int j = 2*i; j <= 1000000; j+=i) nums[j] = 0;
        }

        for (int i = m; i <= n; i++) {
            if (nums[i] != 0) System.out.println(nums[i]);
        }
    }
}
