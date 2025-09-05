package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] DNA = new int[4][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char first = input.charAt(j);

                switch (first) {
                    case 'A':
                        DNA[0][j]++;
                        break;
                    case 'C':
                        DNA[1][j]++;
                        break;
                    case 'G':
                        DNA[2][j]++;
                        break;
                    case 'T':
                        DNA[3][j]++;
                        break;
                }
            }
        }
        int distance = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int max = 0;
            int idx = -1;
            for (int j = 0; j < 4; j++) {
                if (max < DNA[j][i]) {
                    max = DNA[j][i];
                    idx = j;
                }
            }
            switch (idx) {
                case 0:
                    sb.append("A");
                    break;
                case 1:
                    sb.append("C");
                    break;
                case 2:
                    sb.append("G");
                    break;
                case 3:
                    sb.append("T");
                    break;
            }

            for (int j = 0; j < 4; j++) {
                if (idx == j) {
                    continue;
                }
                distance += DNA[j][i];
            }
        }
        sb.append("\n").append(distance);
        System.out.println(sb);
    }
}
// S4 DNA 그리디
// 일단 DNA 라는 배열을 만들어서 행에는 ACGT 라는 유전자와 열에는 입력받은 M개의 유전자를 상태로 가져서
// 빈도 수를 배열의 값으로 가지려고 한다 이때 가장 빈도가 많은 열별로 행(유전자)을 선택해서 문자열로 출력하고
// 남은 유전자의 빈도수들은 총합해서 출력해야된다.
// 근데 이게 만약 횟수가 다 같으면 알파벳수니익에 DNA 를 처음부터 알파벳으로 행을 배정해서 max 값과 비교해서 클경우에만 바뀌게 했다.
// 그래서 idx 라는 인덱스 즉 가장 많은 빈도가 보이는 애를 저장해둬서 이와 다른거를 distance로 따로 빼서 누적해서 더한다.