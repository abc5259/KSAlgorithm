package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1051_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] rectangle = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                rectangle[i][j] = str.charAt(j) - '0';
            }
        }

        int min = Math.min(N, M);

        while (min-- > 1) {
            for (int i = 0; i < N - min; i++) {
                for (int j = 0; j < M - min; j++) {
                    if (rectangle[i][j] != rectangle[i][j + min]) {
                        continue;
                    }
                    if (rectangle[i][j] != rectangle[i + min][j]) {
                        continue;
                    }
                    if (rectangle[i][j] != rectangle[i + min][j + min]) {
                        continue;
                    }
                    min++;
                    System.out.println(min * min);
                    return;
                }
            }
        }
        System.out.println(1);
    }
}
// S3 숫자 정사각형 완전탐색 복습
// 25분
// 그냥 풀었다
// 정사각형은 N과 M의 최소의 사이즈까지 만들 수있고 그 사이즈마저도 각 꼭지의 값이 다르면
// 좌표를 옮기거나 그래도 없다면 사이즈를 줄이거나 해서 해야되고
// 2개의 사이즈가 1개도 없다면 바로 1로 답을 내면된다
// 근데문제는 이제 내 생각에는 가장 큰 사이즈부터 탐색해서 나오자마자 바로 끝내버리는 이게 더 좋다고 생각해서
// min 값부터 증감하면서 탐색했다.