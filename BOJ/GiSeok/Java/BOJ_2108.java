/**
 * 2108 - 통계학 [O|00:20~30:00]
 * 실버3, 시도6
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] modes = new int[8001];
        int sum = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            max = Math.max(num, max);
            min = Math.min(num, min);

            sum += num;
            modes[num + 4000] += 1;
            nums[i] = num;
        }

        Arrays.sort(nums);
        System.out.printf("%d%n", Math.round((double)sum / n));
        System.out.println(nums[n / 2]);

        int mode = 0;
        int maxValue = 0;
        for (int i = 0; i <= 8000; i++) {
            if (maxValue < modes[i]) {
                maxValue = modes[i];
                mode = i - 4000;
            }
        }

        int cnt = 0;
        for (int i = 0; i <= 8000; i++) {
            if (maxValue == modes[i]) cnt++;
            if (cnt == 2) { mode = i - 4000; break; }
        }
        System.out.println(mode);
        System.out.println(max - min);
    }
}
