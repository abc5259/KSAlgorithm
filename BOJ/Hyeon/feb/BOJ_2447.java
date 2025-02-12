package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2447 {
    static char[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        stars = new char[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(stars[i], ' ');
        }

        fillStars(0, 0, N);

        for (int i = 0; i < N; i++) {
            sb.append(stars[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void fillStars(int x, int y, int size) {
        if (size == 1) {
            stars[x][y] = '*';
            return;
        }

        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    // 가운데 블록은 비워둠
                    continue;
                }
                fillStars(x + i * newSize, y + j * newSize, newSize);
            }
        }
    }
}
// G5 별찍기 10 재귀, 분할정복
// 걍 개어려움
// retry