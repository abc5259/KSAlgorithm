package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            sum[i] = (sum[i - 1] + Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            sb.append(sum[j] - sum[i - 1]).append("\n");
        }
        System.out.println(sb);
    }
}
// S3 합 구하기 누적 합
// 4분
// 걍 쉽게 풀었다 구간의 합을 구해야되는데 N과 M이 10만인거보자마자 한번에 합을 다 구해두고 구간별로 값을 쓸 수 있게 해야된다 생각해서
// sum 배열을 메모이제이션? 한거 처럼 누적해서 더한다음에
// M번 입력에서 i 와 j 를 얻고 누적합 구간을 빼주면된다. 2~3까지면 3까지 누적합에서 1까지의 합을빼면 2~3이된다.