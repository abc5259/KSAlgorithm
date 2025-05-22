package BOJ.Hyeon.retry;

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
        System.out.println(sb);
    }

    static void hanoi(int N, int from, int mid, int to) {
        if (N == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(N - 1, from, to, mid);
        // from 에서 mid로
        sb.append(from).append(" ").append(to).append("\n");
        // from 에서 to로 원판 1개
        hanoi(N - 1, mid, from, to);
        // mid 에서 to로
    }
}
// G5 하노이 탑 이동 순서 재귀
// 주어진 N의 값인 3을 이용해서 시작부터 끝까지의 하노이탑의 규칙을 찾으면된다.
// 일단 N개의 하노이탑이 있을 경우
// N-1 개의 원판을 이동시키고 N번째의 원판을 도착지점에 두고 다시 N-1의 원판을 도착지점에 가져다두는 점화식이다
// 분할정복과 재귀의 특성상 가장 작은 단위가 될때까지 재귀를 하고 호출이 되면 다음연산을 하면된다
// N-1 원판이 1이 될때까지 분할하고 1이면 이동하고 from 에서 mid로 이기 떄문에 재귀문을 사용하고
// from에서 to로 N 원판이 움직이고
// mid에서 to로 N-1 원판이 1이 될때까지 움직인다.

