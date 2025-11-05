package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17266 {
    static int N;
    static int[] lamp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        lamp = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            lamp[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(lowerBound());
    }

    static int lowerBound() {
        int lo = 0;
        int hi = N;

        while (lo + 1 < hi) {
            int mid = (hi - lo) / 2 + lo;

            if (check(mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi;
    }

    static boolean check(int var) {
        int tmp = 0; // 빛이 닿은 오른쪽 좌표

        for (int dis : lamp) {
            if (dis - tmp <= var) {
                tmp = dis + var;
            } else {
                return false;
            }
        }
        return N <= tmp;
    }
}
// S4 어두운 굴다리 이분탐색
// 40분
// 와 오랜만에 푸니까 이해가 안됨
// 일단 이분탐색 인가? 굴다리를 비추기 위해 가로등의 최소 높이
// 근데 가로등의 높이를 mid 로 정하면 굴다리 전체를 비출 수 있냐 없냐 이거는 FFF랑 TTT다 그래서 결정 문제로 반환
// 그다음에 check 에서는 mid 즉 높이가 낮아지면 비추는 범위가 좁아서 FF 이고 높이가 개 높으면 T 일 테니
// FFFF..TTTT 일거다 그래서 최초의 T를 구해야 되니까 lowerBound 이다