package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4158 {
    static int N;
    static int[] sang;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) {
                break;
            }

            sang = new int[N];

            for (int i = 0; i < N; i++) {
                sang[i] = Integer.parseInt(br.readLine());
            }

            int cnt = 0;
            for (int i = 0; i < M; i++) {
                int young = Integer.parseInt(br.readLine());
                if (binarySearch(young)) {
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    static boolean binarySearch(int var) {
        int lo = -1;
        int hi = N;

        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;

            if (sang[mid] < var) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return hi < N && sang[hi] == var;
    }
}
// S5 CD 이분탐색
// 15분
// 쉽게 풀었다.