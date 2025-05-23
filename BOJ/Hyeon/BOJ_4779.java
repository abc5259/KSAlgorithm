package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4779 {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str == null || str.isEmpty()) {
                break;
            }

            int N = Integer.parseInt(str);
            cantor(0, (int) Math.pow(3, N));
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void cantor(int x, int N) {
        if (N == 1) {
            sb.append("-");
            return;
        }
        N /= 3;
        cantor(x, N);
        for (int i = 0; i < N; i++) {
            sb.append(" ");
        }
        cantor(x + N * 2, N);
    }
}

// S3 칸토어 집합 분할 정복
// 재귀 문제로 N의 기저사례를 찾아서 1까지 간다음에 - 를 출력에 등록하고
// 사이즈를 분할하는 N/3을 통해서 다음 사이즈의 재귀호출을 한다
// 이때 왼쪽 가운데 오른쪽으로 나눴다고 생각하면 왼쪽을 재귀하고 나면 다시 빈칸을 채우고 오른쪽을 재귀호출한다.