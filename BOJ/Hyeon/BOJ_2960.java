package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2960 {
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];

        int cnt = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                if (!visit[j]) {
                    visit[j] = true;
                    cnt++;
                }
                if (cnt == K) {
                    System.out.println(j);
                    return;
                }
            }
        }
    }
}
// S4 에라토스테네스의 체 구현
// 1분
// 걍 풀었다 진짜 너무 소름돋음
// 근데 거의구현같았다 왜냐하면 i는 2부터 N까지의 수이고
// i의 숫자를 선택했을 때 내부의 반복문으로 i 만큼의 숫자를 증가 시켜서 이를 방문형태로 가지고
// cnt 의 개수가 K와 같아졌을 때 탈출하는 문제이다.