package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2448 {
    static char[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        stars = new char[N][N * 2 - 1];
        for (char[] star : stars) {
            Arrays.fill(star, ' ');
        }
        fillStars(0, N - 1, N);
        StringBuilder sb = new StringBuilder();
        for (char[] star : stars) {
            sb.append(star).append("\n");
        }
        System.out.println(sb);
    }

    private static void fillStars(int row, int col, int n) {
        if (n == 3) {
            stars[row][col] = '*';
            stars[row + 1][col - 1] = stars[row + 1][col + 1] = '*';
            stars[row + 2][col - 2] = stars[row + 2][col - 1] = stars[row + 2][col]
                    = stars[row + 2][col + 1] = stars[row + 2][col + 2] = '*';
            return;
        }

        int size = n / 2;
        fillStars(row, col, size);
        fillStars(row + size, col - size, size);
        fillStars(row + size, col + size, size);
    }
}

// G4 별 찍기 - 11 재귀
// 일단 기저 사례를 제대로 정해야된다. k가 0부터 가능해서 N은 3부터 가능하고
// 3일때 * 을 그려야되니까 이것이 기저사례이다.
// 그런데 시작 좌표가 0,0이 아닌 0, N-1 이고 그다음 별은 1, N-2, 1, N이런식이고
// 세번째 줄은 N-3 ~ N+1 까지인 5개의 좌표이다.

// 3 6 12 24 와 같이 2의 배수로 진행돼서 size를 2로 나눠서 재귀를 하게끔 하고
// 삼각형은 3갈래에만 색을 칠하고 나머지는 빈칸으로 채워둬서 fill로 빈칸으로 채우고 2차원 배열을
// fillstars로 *을 채웠따.