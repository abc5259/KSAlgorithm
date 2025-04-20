package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2615 {
    static int[][] five;
    final static int N = 19;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        five = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                five[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int stone = five[i][j];
                if (stone != 0) {
                    if (isValid(i, j, stone)) {
                        System.out.println(stone);
                        System.out.println((i + 1) + " " + (j + 1));
                        return;
                    }
                }
            }
        }
        System.out.println(0);
        // 1 ㄱㅓㅁ사 ->? 5개면 1 하고 가장 위의 행 열 출력
        // 2검사->? 5개면 2 하고 가장 위의 행 열 출력
        // 3은 3이라고 출력
    }

    static boolean isValid(int row, int col, int stone) {
        int[] cnt = {1, 1, 1, 1};
        for (int i = row; i < N; i++) {
            for (int j = col; j < N; j++) {

                if (j + 1 < N) {

                    int tmp2 = j + 1;

                    while (tmp2 < N && five[i][tmp2] == stone) {
                        if (cnt[0] == 5) {
                            return true;
                        }
                        cnt[0]++;
                        tmp2++;
                    }
                    if (cnt[0] == 5) {
                        return true;
                    } else {
                        cnt[0] = 1;
                    }
                }
                if (i + 1 < N) {
                    int tmp1 = i + 1;

                    while (tmp1 < N && five[tmp1][j] == stone) {
                        if (cnt[1] == 5) {
                            return true;
                        }
                        cnt[1]++;
                        tmp1++;
                    }
                    if (cnt[1] == 5) {
                        return true;
                    } else {
                        cnt[1] = 1;
                    }
                }
                if (j + 1 < N && i + 1 < N) {
                    int tmp1 = i + 1;
                    int tmp2 = j + 1;

                    while (tmp1 < N && tmp2 < N && five[tmp1][tmp2] == stone) {
                        if (cnt[2] == 5) {
                            return true;
                        }
                        cnt[2]++;
                        tmp1++;
                        tmp2++;
                    }
                    if (cnt[2] == 5) {
                        return true;
                    } else {
                        cnt[2] = 1;
                    }
                }
                if (j + 1 < N && i > 0) {
                    int tmp1 = i;
                    int tmp2 = j + 1;

                    while (tmp1 > 0 && tmp2 < N && five[tmp1][tmp2] == stone) {
                        if (cnt[3] == 5) {
                            return true;
                        }
                        cnt[3]++;
                        tmp1--;
                        tmp2++;
                    }
                    if (cnt[3] == 5) {
                        return true;
                    } else {
                        cnt[3] = 1;
                    }
                }
            }
        }
        return false;
    }
}
