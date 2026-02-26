package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20125 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int heartX = 0, heartY = 0;

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (map[i][j] == '*') {
                    if (map[i - 1][j] == '*' && map[i][j + 1] == '*' && map[i + 1][j] == '*' && map[i][j - 1] == '*') {
                        heartX = i;
                        heartY = j;
                        break;
                    }
                }
            }
            if (heartX != 0) {
                break;
            }
        }

        int leftArm = 0;
        int tmpY = heartY - 1;
        while (tmpY >= 0 && map[heartX][tmpY] == '*') {
            leftArm++;
            tmpY--;
        }

        int rightArm = 0;
        tmpY = heartY + 1;

        while (tmpY < N && map[heartX][tmpY] == '*') {
            rightArm++;
            tmpY++;
        }

        int waist = 0;
        int tmpX = heartX + 1;

        while (tmpX < N && map[tmpX][heartY] == '*') {
            waist++;
            tmpX++;
        }

        int waistEndX = heartX + waist;

        int leftLeg = 0;
        tmpX = waistEndX + 1;
        while (tmpX < N && map[tmpX][heartY - 1] == '*') {
            leftLeg++;
            tmpX++;
        }

        int rightLeg = 0;
        tmpX = waistEndX + 1;
        while (tmpX < N && map[tmpX][heartY + 1] == '*') {
            rightLeg++;
            tmpX++;
        }

        System.out.println((heartX + 1) + " " + (heartY + 1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
}
// S4 쿠키의 신체 측정 구현
// 16분
// 그냥 풀었다.
// 좌표별로 y랑 x 만 바껴있을 뿐 그냥 심장으로 팔 허리 구한다음
// 허리의 끝을 통해서 양쪽 다리를 구했다.