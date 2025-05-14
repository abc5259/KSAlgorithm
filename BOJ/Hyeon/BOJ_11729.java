package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11729 {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        sb.append((int) Math.pow(2, N) - 1).append("\n");
        hanoi(N, 1, 2, 3);
        System.out.print(sb);
    }

    public static void hanoi(int N, int from, int pass, int to) {
        if (N == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(N - 1, from, to, pass);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(N - 1, pass, from, to);
    }
}

