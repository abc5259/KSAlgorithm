/**
 * 00:20:29 S4
 */
package BOJ.GiSeok.Java.retry;

import java.util.*;
import java.io.*;

public class BOJ_1940 {
    private static int[] materials;
    private static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        materials = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(materials);

        int left = 0;
        int right = n-1;
        while (left < right) {
            int sum = materials[left] + materials[right];

            if (sum > m) {
                right--;
            }
            if (sum == m) {
                ans++;
                left++;
                right--;
            }
            if (sum < m) {
                left++;
            }
        }

        System.out.println(ans);
    }
}
