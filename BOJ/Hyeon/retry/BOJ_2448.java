package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2448 {
    static char[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        stars = new char[N][N * 2 - 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(stars[i], ' ');
        }

        fillStars(0, N - 1, N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void fillStars(int y, int x, int size) {
        if (size == 3) {
            stars[y][x] = '*';
            stars[y + 1][x - 1] = stars[y + 1][x + 1] = '*';
            stars[y + 2][x - 2] = stars[y + 2][x - 1] = stars[y + 2][x] = stars[y + 2][x + 1] = stars[y + 2][x + 2] = '*';
        } else {
            int cut = size / 2;
            fillStars(y, x, cut);
            fillStars(y + cut, x - cut, cut);
            fillStars(y + cut, x + cut, cut);
        }
    }
}

// G4 별찍기 11
// 개어려움 다시풀자