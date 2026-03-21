package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15489 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        if (W == 1) {
            System.out.println(com(R - 1, C - 1));
            return;
        }

        long sum = 0;

        sum += com(R - 1, C - 1);

        for (int i = 0; i < W; i++) {
            long tmp = com(R + W - 2, C - 1 + i);
            if (0 < i && i < W - 1) {
                sum += tmp;
            }
            sum += tmp;
        }

        System.out.println(sum);
    }

    static long com(int a, int b) {

        b = Math.min(a - b, b);
        long res = 1;

        for (int i = 0; i < b; i++) {
            res = res * (a - i) / (i + 1);
        }
        return res;
    }
}
// S4 파스칼 삼각형 수학
// DP로도 풀어보자.
// 27분
// 일단 풀었다 삼각형 기준으로 맨 위와 하단의 양쪽을 더하고 하단의 양쪽 가운데 부분을 2배로 더했다.
// 그래서 com 으로 combination 계산 식을 만들고 또 30 까지가 가능해서 long 으로 가능하게 했고
// W가 1일때의 엣지케이스를 고려해서 연산했다.