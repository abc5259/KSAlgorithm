package BOJ.Hyeon.retry;

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
// 3개로 계쏙해서 분할해서 1개가 남을때까지 한다음에 그 1개는 [1][1]을 안가는 값일 때 '*'을 저장하고
// [1][1]은 공백으로 그대로 두어야 하는데, N이 27에서 9가 될 때 1, 1은 9 X9 칸 모두 공백이다
// 처음부터 접근방식이 배열에다가 다 비워놓고 별을 찍는걸로 생각했다.