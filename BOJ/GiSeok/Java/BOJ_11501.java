package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_11501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] nums = new int[n];
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) nums[i] = Integer.parseInt(input[i]);

            long sum = 0;
            int max = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (max < nums[i]) max = nums[i];
                else sum += (max - nums[i]);
            }

            System.out.println(sum);
        }
    }
}
