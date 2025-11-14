package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18511 {
    static int res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, N);

        System.out.println(res);
    }

    static void dfs(int num, int N) {
        if (num > N) {
            return;
        }

        res = Math.max(res, num);

        for (int a : arr) {
            dfs(num * 10 + a, N);
        }
    }
}
// S5 큰 수 구성하기
// 일단 풀었음 복습 필