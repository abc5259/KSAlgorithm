package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2512 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        M = Integer.parseInt(br.readLine());

        System.out.print(solve(max));
    }

    static int solve(int var) {

        int lo = 1;
        int hi = var + 1;

        while (lo + 1 < hi) {

            int mid = (hi - lo) / 2 + lo;

            if (check(mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    static boolean check(int mid) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Math.min(arr[i], mid);
        }
        return sum <= M;
    }
}
// S2 예산 이분탐색
// 예산 문제 상한액이 120일때 True 면 100도 true 니까 TTTT FFFF 구조이다
// 결정함수 check 를 통해서 상한액이 X 일 때 Yes / No 하면된다.
// 16분 ㅋㅋ 파라메트릭 서치
// 일단 lo 를 구하는 문제 였다 왜냐하면 TTTT FFFF를 구하는건데 가장 큰 T를 구하는거다 이게
// 그래서 익스클루시브 hi 를 통해서 lo 는 1부터 max 값까지 가능하다 근데 var 을 10만으로 박아넣고 하면 문제가 된다
// 왜냐?? 바로 mid 탐색이 check 에 갔을때 항상 배열의 합이 sum 이되는데 이게 M 보다 작기만 하면 계속해서 TTT가 상승한다
// 근데 다 합쳐도 M 이 안되면 계속해서 줄어들어야 되는데,, F에서 T로 이게 문제였다
// lo를 구하는것을 눈치를 빠르게 챘다 왜냐하면 TTTT FFFF 이기 떄문