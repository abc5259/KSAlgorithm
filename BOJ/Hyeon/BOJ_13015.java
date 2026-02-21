package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < N; j++) {
            sb.append("*");
        }
        for (int j = 0; j < N * 2 - 3; j++) {
            sb.append(" ");
        }
        for (int j = 0; j < N; j++) {
            sb.append("*");
        }
        sb.append("\n");
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j <= i; j++) {
                sb.append(" ");
            }
            sb.append("*");
            for (int j = 0; j < N - 2; j++) {
                sb.append(" ");
            }
            sb.append("*");
            for (int j = 0; j < (N - 2 - i) * 2 - 1; j++) {
                sb.append(" ");
            }
            sb.append("*");
            for (int j = 0; j < N - 2; j++) {
                sb.append(" ");
            }
            sb.append("*").append("\n");
        }
        for (int j = 0; j < N - 1; j++) {
            sb.append(" ");
        }
        sb.append("*");
        for (int j = 0; j < N - 2; j++) {
            sb.append(" ");
        }
        sb.append("*");
        for (int j = 0; j < N - 2; j++) {
            sb.append(" ");
        }
        sb.append("*").append("\n");

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < N - 2 - i; j++) {
                sb.append(" ");
            }
            sb.append("*");
            for (int j = 0; j < N - 2; j++) {
                sb.append(" ");
            }
            sb.append("*");
            for (int j = 0; j < i * 2 + 1; j++) {
                sb.append(" ");
            }
            sb.append("*");
            for (int j = 0; j < N - 2; j++) {
                sb.append(" ");
            }
            sb.append("*").append("\n");
        }
        for (int j = 0; j < N; j++) {
            sb.append("*");
        }
        for (int j = 0; j < N * 2 - 3; j++) {
            sb.append(" ");
        }
        for (int j = 0; j < N; j++) {
            sb.append("*");
        }
        sb.append("\n");
        System.out.println(sb);
    }
}
// S4 별찍기 - 23 구현
// 43분
// 아그냥 계속해서 증감식에 대해서 계산을 못해서 허둥댔다.
// 그냥 순서대로 구현해버렸다 재귀문을 찾을 수 없었음.
// (N - 2 - i) * 2 - 1 이런 증감식에 대해서 너무 고민이 돼서 구하는데 시간을 다썼다.