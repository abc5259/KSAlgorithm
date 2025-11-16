package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] condo = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                condo[i][j] = line.charAt(j);
            }
        }

        int row = 0, col = 0;

        for (int i = 0; i < N; i++) {
            int possible = 0;
            for (int j = 0; j < N - 1; j++) {
                if (condo[i][j] == '.' && condo[i][j + 1] == '.') {
                    possible++;
                } else {
                    if (possible >= 1) {
                        col++;
                        possible = 0;
                    }
                }
            }
            if (possible >= 1) {
                col++;
            }
            possible = 0;
            for (int j = 0; j < N - 1; j++) {
                if (condo[j][i] == '.' && condo[j + 1][i] == '.') {
                    possible++;
                } else {
                    if (possible >= 1) {
                        row++;
                        possible = 0;
                    }
                }
            }
            if (possible >= 1) {
                row++;
            }
        }
        System.out.println(col + " " + row);
    }
}
// S5 누울 자리를 찾아라 슬라이딩 윈도우
// 20분
// 일단 복습 차원에서 다시한건데 문제 이해가 잘못되었다
// problem
// 2칸이상 빈칸이 존재하면 누울 자리로 가능 예를들어 ..X.. 이면 2자리가 가능하다
// 그래서 연속된 2자리가 있기만 하면되니까 슬라이딩 윈도우 즉 창문을 2칸으로 정의하고 창문이 열려진 possible
// 변수가 1개이상인데다가 창문이 없고 짐이 있는 곳이면 현재까지 1개의 창문이 있다면 row 와 col를 각각 증가하면된다
