package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] square = new boolean[101][101];

        int sum = 0;

        StringTokenizer st;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    if (!square[y][x]) {
                        square[y][x] = true;
                        sum++;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
// S5 직사각형 네개의 합집합의 면적 구하기 구현
// 7분
// 그냥 풀었다. 중복되는 것과 상관없이 2개의 좌표를 통해 내재되어있는 직사각형을
// visit 101 * 101 개의 배열을 통해서 중복상관없이 색칠 안되어있으면 색칠하고
// 색칠된 것들의 대한 합을 반환