package BOJ.GiSeok.Java;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1080 {
    public static int N, M;
    public static int[][] A, B;

    public static boolean isSameAB() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        B = new int[N][M];

        for (int AB = 0; AB < 2; AB++) {
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < M; j++) {
                    if (AB == 0)
                        A[i][j] = s.charAt(j) == '0' ? 0 : 1;
                    else
                        B[i][j] = s.charAt(j) == '0' ? 0 : 1;
                }
            }
        }

        int ans = 0;

        if (N < 3 || M < 3) {
            if (isSameAB()) {
                System.out.println(ans);
                return;
            }
        }

        for (int i = 0; i <= N-3; i++) {
            for (int j = 0; j <= M-3; j++) {
                if (A[i][j] != B[i][j]) {
                    for (int b = i; b < i+3; b++) {
                        for (int c = j; c < j+3; c++) {
                            A[b][c] = A[b][c] == 1 ? 0 : 1;
                        }
                    }
                    ans+=1;
                }

                if (isSameAB()) {
                    System.out.println(ans);
                    return;
                }
            }
        }

        if (!isSameAB())
            System.out.println(-1);
    }
}
