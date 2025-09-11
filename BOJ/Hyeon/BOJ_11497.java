package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] tong = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                tong[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(tong);

            int start = tong[0];
            int end = tong[0];

            int res = 0;

            for (int i = 1; i < N; i++) {
                int tmp;

                if (i % 2 == 1) {
                    tmp = Math.abs(start - tong[i]);
                    start = tong[i];
                } else {
                    tmp = Math.abs(end - tong[i]);
                    end = tong[i];
                }
                res = Math.max(res, tmp);
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }
}
// S1 통나무 건너뛰기 그리디, 정렬
// 일단 tong 배열을 통해서 나무들의 높이를 자료구조로 저장하고
// 오름차순으로 한다 그이유는
// 맨앞은 2번째와 맨마지막이랑도 비교하기 때문에 start 와 end 변수에 맨 앞 값을 가지고
// 2번재 자리부터 순차적으로 홀수는 start 랑 짝수는 end 랑 비교하면서 나열된다 이때 tmp 값이 최대가 되는 경우를 가져야 한다.
// 근데 우리의 목표가 말이 최대값이지 제일 작은것중 최대이기 때문에 오름차로 나열한거다.
