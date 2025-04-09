package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10972 {
    static int[] input;
    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        next_perm();
        System.out.println(sb);
    }

    static void next_perm() {
        int idx = N - 1;
        while (idx > 0 && input[idx - 1] > input[idx]) {
            idx--;
        }
        if (idx == 0) {
            sb.append(-1);
            return;
        }
        int def = N - 1;
        while (def > idx && input[idx - 1] > input[def]) {
            def--;
        }
        int tmp = input[idx - 1];
        input[idx - 1] = input[def];
        input[def] = tmp;
        Arrays.sort(input, idx, N);
        for (int i : input) {
            sb.append(i).append(" ");
        }
    }
}
