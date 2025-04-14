package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10819 {
    static int N, max;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        input = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        max = Integer.MIN_VALUE;
        while (true) {
            if (!next_perm()) {
                break;
            }
        }
        System.out.print(max);
    }

    static boolean next_perm() {
        int left = N - 1;

        while (left > 0 && input[left - 1] >= input[left]) {
            left--;
        }
        if (left == 0) {
            return false;
        }
        int right = N - 1;

        while (input[left - 1] >= input[right]) {
            right--;
        }
        swap(left - 1, right);

        right = N - 1;
        while (left < right) {
            swap(left, right);
            left++;
            right--;
        }
        int sum = 0;

        for (int i = 1; i < N; i++) {
            int dif = input[i] - input[i - 1];
            sum += Math.abs(dif);
        }
        max = Math.max(max, sum);
        return true;
    }

    static void swap(int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }
}
