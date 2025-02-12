package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074 {
    static int N, r, c, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        N = (int) Math.pow(2, N);

        z(0, 0);

        System.out.println(res);
    }

    static void z(int y, int x) {
        if (N == 1) {
            return;
        }
        N /= 2;
        if (r < y + N && c < x + N) {
            z(y, x);
        } else if (r < y + N) {
            res += N * N * 1;
            z(y, x + N);
        } else if (c < x + N) {
            res += N * N * 2;
            z(y + N, x);
        } else {
            res += N * N * 3;
            z(y + N, x + N);
        }
    }
}
// Z 머지쇼트