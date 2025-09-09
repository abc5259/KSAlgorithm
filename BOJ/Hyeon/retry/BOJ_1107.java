package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107 {
    static boolean[] extend;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        extend = new boolean[10];
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                extend[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int res = Math.abs(N - 100);

        for (int i = 0; i < 1_000_001; i++) {
            int len = getCnt(i);

            if (len > 0) {
                res = Math.min(res, Math.abs(N - i) + len);
            }
        }
        System.out.print(res);
    }

    private static int getCnt(int num) {
        if (num == 0) {
            return extend[num] ? 0 : 1;
        }

        int len = 0;
        while (num > 0) {
            int mod = num % 10;
            if (extend[mod]) {
                return 0;
            }
            num /= 10;
            len++;
        }
        return len;
    }
}
// G4 리모컨 브루트포스
// trouble
// 일단 그리디로 접근했다 왜냐하면 자릿수마다 절대값이 적은거로 해서 가까운 버튼을 눌리게 하려고 했는데
// 80000이 있는데 예시로 나는 그러면 70000이 된다 절대값으로 비교하기에 근데 정답은 77777이다
// 그래서 브루트 포스를 하게 되었다.

// 0부터 100만이다 왜나면 50만인데 더큰거에서 빼게금 딱 2배만큼 범위
// 1. 초기값은 근데 100이라서 N에서 100만큼 절대값을 가지고 있다 이는 +나 -로만 접근하겠단 마인드
// 2. for 문으로 0부터 조회하돼 i번 채널이 cnt 해서 0이상이어야만 가능하다
// 메소드 추출한거고 원래라면 0인지 판단하고 아니면 자릿수 구해서 포함되는 수 없으면 리턴해버린다
// 그리고 그 숫자 자리수 + 절대값(+나 -횟수) 해서 구하면된다.

// String.valueOf()썻었는데 객체를 계속만드니까 별로더라고
