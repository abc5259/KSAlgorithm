package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_10810 {

    static int[] nums;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        n = Integer.parseInt(input.split(" ")[0]);
        m = Integer.parseInt(input.split(" ")[1]);

        nums = new int[n+1];

        for (int a = 0; a < m; a++) {
            String tmp = br.readLine();

            int i = Integer.parseInt(tmp.split(" ")[0]);
            int j = Integer.parseInt(tmp.split(" ")[1]);
            int k = Integer.parseInt(tmp.split(" ")[2]);

            for (int b = i; b <= j; b++) {
                nums[b] = k;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
