package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19939 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int tmp = 0;

        for (int i = 1; i <= K; i++) {
            tmp += i;
        }

        if (N < tmp) {
            System.out.println(-1);
        } else {
            if ((N - tmp) % K == 0) {
                System.out.println(K - 1);
            } else {
                System.out.println(K);
            }
        }
    }
}
// S4 박 터뜨리기 그리디
// 50분
// trouble shooting
// 아니 딱봐도 조합처럼 푸는거 같아서 백트래킹 써서 N 개의 공 K 개 답는 거
// 재귀해서 깊이 K 일때까지 했는데 입력값이 N이 10만이라서 시간초과를 발생
// 해결
// 최적의 상태를 만드는 그리디 K 개 바구니에 들어있는 공의 개수가 모두 달라야 하고 최소로 할거면
// 1부터 K 까지 의 합에대해서 가지고 있고 남는 공은 만약 K의 배수면 +1 씩 다 더해버리면되니까
// 최대와 최소의 차이는 없다 1과 K 라서 K-1 이 정답이 되고
// 배수가 아니라면 가장 많이 담긴 바구니부터 채워야되니까,, 전부다 +1씩하지말고 뒤에서 부터 채워서
// 1과 K+1 이 돼서 정답이 K가 된다.