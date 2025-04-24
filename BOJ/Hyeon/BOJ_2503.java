package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] visit = new boolean[988];

        for (int i = 123; i < 988; i++) {
            String s = String.valueOf(i);
            if (s.charAt(0) == '0' || s.charAt(1) == '0' || s.charAt(2) == '0') {
                continue;
            }
            if (s.charAt(0) == s.charAt(1) || s.charAt(1) == s.charAt(2) || s.charAt(2) == s.charAt(0)) {
                continue;
            }
            visit[i] = true;
        }

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int i = 123; i < 988; i++) {
                if (visit[i]) {
                    int sCnt = 0;
                    int bCnt = 0;

                    char[] req = String.valueOf(num).toCharArray();
                    char[] ans = String.valueOf(i).toCharArray();

                    for (int j = 0; j < 3; j++) {
                        for (int k = 0; k < 3; k++) {
                            if (req[j] == ans[k]) {
                                if (j == k) {
                                    sCnt++;
                                } else {
                                    bCnt++;
                                }
                            }
                        }
                    }

                    if (sCnt != s || bCnt != b) {
                        visit[i] = false;
                    }
                }
            }
        }
        int res = 0;
        for (boolean b : visit) {
            if (b) {
                res++;
            }
        }
        System.out.print(res);
    }
}

// S3 숫자 야구 브루트포스
// 일단 풀기는 했는데 좀 더 나은 방향으로 리팩토링 중이다
// 브루트포스 문제 특성상 쉽게 접근하지 못하는 단점을 고쳐야만 한다.

// 풀이과정 자리별로 중복되는 숫자가 없으며, 0은 포함되지 않기 때문에 123 부터 987 까지가 범위이고
// 그 사이 조건에 부합하는 경우만 true 로 해서 boolean 배열을 만든다.
// 그리고 조건이 참인 애들만 해서 스트라이크와 볼의 개수를 센다
// 입력받은 숫자와 true인 숫자와 비교를 해서 s와 b값이 같을 때 true의 숫자는 true 조건을 통과하여 가능성이 생겼다
// 그래서 true의 숫자들만의 갯수가 답이다.