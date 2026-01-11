package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9613 {
    static int n;
    static long res;
    static int[] arr;
    static int[] choice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());

            arr = new int[n];
            choice = new int[2];

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            res = 0;
            dfs(0, 0);

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int start, int depth) {
        if (depth == 2) {
            res += getGCD(choice[0], choice[1]);
            return;
        }

        for (int i = start; i < n; i++) {
            choice[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }

    static int getGCD(int a, int b) {

        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
// S4 GCD 합 백트래킹, 유클리드 호제법
// 25분
// 일단 GCD 를 구하는 로직인 유클리드 호제법을 썻다
// 두 수 a 와 b 에 대해 a % b == r 일때 GCD (a,b) == GCD(b,r) 을 성립
// b 가 0일 때까지 하고 이에 대한 a 값을 리턴한다
// 더 큰 수로 작은 수를 나눠서 더 큰값을 살아남게 하는게 목표
// 그리고 n 개 중 2개의 최대공약수의 합이기에 조합을 써서 백트래킹으로 접근했다.
// trouble
// n이 100이고 값은 100만이 최대라서 100개중에 2개를 뽑으면 가짓수는
// 4950 개이고 여기서 모든 값이 100만이면 49억이기에 int 는 오버 플로우가 발생된다.