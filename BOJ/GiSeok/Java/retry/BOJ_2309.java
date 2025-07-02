package BOJ.GiSeok.Java.retry;

/**
 * 00:15:48 B1
 */
import java.util.*;
import java.io.*;

public class BOJ_2309 {
    private static final int[] small = new int[9];
    private static final boolean[] visited = new boolean[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            small[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(small);
        permutation(9, 7, 0);
    }

    private static void permutation(int n, int r, int now) {
        if (r == now) {
            int sum = calculateTotalSum(r);

            if (sum == 100) {
                for (int i = 0; i < r; i++) {
                    System.out.println(small[i]);
                }
                System.exit(0);
            }
        }

        for (int i = now; i < n; i++) {
            swap(i, now);
            permutation(n, r, now+1);
            swap(i, now);
        }
    }

    private static void swap(int idx1, int idx2) {
        int tmp = small[idx1];
        small[idx1] = small[idx2];
        small[idx2] = tmp;
    }

    private static int calculateTotalSum(int r) {
        int sum = 0;
        for (int i = 0; i < r; i++) {
            sum += small[i];
        }
        return sum;
    }

    private static void dfs(int n, int cnt, int now) {
        if (cnt > 7) return;
        if (n > 100) return;
        if (n == 100 && cnt == 7) {
            for (int i = 0; i < 9; i++) {
                if (!visited[i]) continue;
                System.out.println(small[i]);
            }
            System.exit(0);
        }

        for (int i = now+1; i < 9; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(n + small[i], cnt+1, i);
            visited[i] = false;
        }
    }
}
