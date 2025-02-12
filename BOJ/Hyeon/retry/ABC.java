package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ABC {
    static char[][] stars;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        stars = new char[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(stars[i], ' ');
        }

        fillStars(0, 0, N);
        for (int i = 0; i < N; i++) {
            sb.append(stars[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void fillStars(int x, int y, int size) {

        if (size == 1) {
            stars[x][y] = '*';
            return;
        }

        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                fillStars(x + i * newSize, y + j * newSize, newSize);
            }
        }
    }
}
