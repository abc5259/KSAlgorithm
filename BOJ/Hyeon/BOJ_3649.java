package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3649 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str == null || str.isEmpty()) {
                break;
            }
            int x = Integer.parseInt(str) * 10_000_000;

            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);

            int lo = 0;
            int hi = n - 1;

            boolean isX = false;
            while (lo < hi) {
                int sum = arr[lo] + arr[hi];
                if (sum == x) {
                    isX = true;
                    break;
                } else if (sum > x) {
                    hi--;
                } else {
                    lo++;
                }
            }
            if (isX) {
                sb.append("yes").append(" ").append(arr[lo]).append(" ").append(arr[hi]);
            } else {
                sb.append("danger");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
