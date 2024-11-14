/**
 * 1966. 숫자를 정렬하자 (D2|정렬) [O]
 */
package Swea.Giseok;

import java.io.*;
import java.util.*;

public class swea_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(nums);
            System.out.print("#" + t + " ");
            for (int i = 0; i < n; i++) System.out.print(nums[i] + " ");
            System.out.println();
        }

    }
}