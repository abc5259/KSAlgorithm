package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long max = 0;
            long total = 0;

            for (int i = N - 1; i >= 0; i--) {
                if (arr[i] > max) {
                    max = arr[i];
                } else {
                    total += max - arr[i];
                }
            }
            sb.append(total).append("\n");
        }
        System.out.println(sb);
    }
}
// S2 주식 그리디
// 40분
// Trouble shooting
// 일단 buying과 queue ,pq 이렇게 3개의 자료구조로 접근했다 buying 이 사고 지나간 날
// queue 는 매 날마다 오는 장 그리고 PQ 는 최대값을 기억하는 내림차순으로 정렬한 거였다.
// 주식은 근데 현재시점 이후 미래의 최대값만 유효하다 PQ 로 인해 과거의 최대값을 불러온다.
// 매수 한 값과 최대값만 있고 총합 배리어블만 있어도 문제없다 그래서
// buying 은 변수로 해결 queue 는 arr 배열을 통해서 하고 PQ 는 arr 배열을 뒤에서 부터 역행순회해서
// 값을 구하면되기 때문에 pq 도 안쓰인다.
// 해결
// 마지막 날부터 탐색해서 최대값이 갱신될때까지 계속 팔다가 갱신하고 그런식이다
// 처음에 최대값이 들어오면 끝까지 total 은 0 이고 최대값이 갱신까지 total 에 증가하다가
// 갱신 후 끝날 수 있다.