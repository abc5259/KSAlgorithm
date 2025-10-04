package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17266 {
    static int N, M;
    static int[] lamp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        M = Integer.parseInt(br.readLine());
        lamp = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            lamp[i] = Integer.parseInt(st.nextToken());
        }

        System.out.print(binarySearch());
    }

    static int binarySearch() {

        int lo = 0;
        int hi = N;

        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;

            if (check(mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi;
    }

    static boolean check(int var) {
        int tmp = 0;

        for (int i = 0; i < M; i++) {
            if (lamp[i] - var <= tmp) {
                tmp = lamp[i] + var;
            } else {
                return false;
            }
        }
        return N <= tmp;
    }
}
// S4 어두운 굴다리 이분 탐색
// 일단 풀었다.
