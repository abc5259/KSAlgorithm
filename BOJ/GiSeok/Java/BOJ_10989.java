/**
 * 10989 - 수 정렬하기 3(B1|정렬) [O(질문힌트)]
 * 시도9
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(br.readLine());
        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(nums[i]).append("\n");

        System.out.println(sb);
    }
}