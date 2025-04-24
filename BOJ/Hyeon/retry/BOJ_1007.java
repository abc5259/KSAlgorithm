package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1007 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] vec = new int[N][2];
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                vec[i][0] = Integer.parseInt(st.nextToken());
                vec[i][1] = Integer.parseInt(st.nextToken());
            }
            int[] sign = new int[N];
            for (int i = 0; i < N; i++) {
                if (i < N / 2) {
                    sign[i] = 1;
                } else {
                    sign[i] = -1;
                }
            }
            Arrays.sort(sign);

            double res = Double.MAX_VALUE;
            do {
                int sumX = 0, sumY = 0;
                for (int i = 0; i < N; i++) {
                    sumX += sign[i] * vec[i][0];
                    sumY += sign[i] * vec[i][1];
                }
                double len = Math.sqrt((long) sumX * sumX + (long) sumY * sumY);
                if (len < res) {
                    res = len;
                }
            } while (next_perm(sign));
            System.out.println(res);
        }
    }

    static boolean next_perm(int[] arr) {
        int left = arr.length - 1;
        while (left > 0 && arr[left - 1] >= arr[left]) {
            left--;
        }
        if (left == 0) {
            return false;
        }
        int right = arr.length - 1;
        while (arr[left - 1] >= arr[right]) {
            right--;
        }
        swap(arr, left - 1, right);
        right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
        return true;
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
