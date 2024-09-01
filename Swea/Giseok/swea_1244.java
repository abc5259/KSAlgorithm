/**
 * 1244. [S/W 문제해결 응용] 2일차 - 최대 상금 [성공|00:44:54]
 * D3, 조합, 시도10
 */
package Swea.Giseok;
import java.io.*;
import java.util.StringTokenizer;

public class swea_1244 {

    static int[] nums;
    static int r, ret;

    static void swap(int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    static void go(int R) {
        if (R == r) {
            int max = 0;
            for (int i = 0; i < nums.length; i++)
                max = (max * 10) + nums[i];

            ret = Math.max(max, ret);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                swap(i, j);
                go(R + 1);
                swap(i, j);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ret = 0;
            String n = st.nextToken();
            r = Integer.parseInt(st.nextToken());
            nums = new int[n.length()];
            for (int i = 0; i < n.length(); i++) nums[i] = n.charAt(i) - '0';

            if (nums.length < r) r = nums.length;

            go(0);
            System.out.println("#" + test_case + " " + ret);
        }
    }
}
