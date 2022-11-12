package BOJ.GiSeok.Java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_9663 {
    static int ans = 0;
    static int[] chess;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        chess = new int[N];

        nQueen(0);

        System.out.println(ans);
    }

    static void nQueen(int deep) {
        if (deep == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            chess[deep] = i;
            if (check(deep))
                nQueen(deep+1);
        }
    }

    static boolean check(int idx) {
        for (int i = 0; i < idx; i++) {
            if (chess[i] == chess[idx])
                return false;
        }

        for (int i = 0; i < idx; i++) {
            if (Math.abs(idx - i) == Math.abs(chess[idx] - chess[i]))
                return false;
        }

        return true;
    }
}
