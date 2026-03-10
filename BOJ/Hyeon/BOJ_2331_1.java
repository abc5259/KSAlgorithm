package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2331_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] visit = new int[250_000];

        visit[A] = 1;

        int n = A;
        while (true) {
            int sum = 0;
            int val = visit[n] + 1;

            while (n > 0) {
                sum += cal(n % 10, P);
                n /= 10;
            }

            if (visit[sum] == 0) {
                visit[sum] = val;
                n = sum;
            } else {
                System.out.println(visit[sum] - 1);
                return;
            }
        }
    }

    static int cal(int tmp, int P) {
        int sum = 1;
        while (P-- > 0) {
            sum *= tmp;
        }
        return sum;
    }
}
// S4 반복수열 구현
// 새로운 풀이
// visit 배열을 고려해서 중복을 체크하는 카운트를 고려하긴 했었는데
// 내가 size 를 모를거같아서 포기했는데 boolean 이 아닌 int 로 해서
// 현재까지의 횟수를 점차 누적해서 더해가면 내가 visit 한 장소의 -1 을 하면
// 중복되지 않은 반복수열의 개수를 알 수 있었다.