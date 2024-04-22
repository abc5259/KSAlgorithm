package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ns = br.readLine().split(" ");
        int N = Integer.parseInt(ns[0]);
        int S = Integer.parseInt(ns[1]);

        int[] sequence = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            sequence[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0;
        int sum = 0;

        int ans = 100001;
        while (end <= N) {
            if (sum < S) {
                if (end == N) break;
                sum += sequence[end++];
            } else {
                ans = Math.min(ans, end - start);
                sum -= sequence[start++];
            }
        }

        if (ans == 100001) ans = 0;
        System.out.println(ans);
    }
}
