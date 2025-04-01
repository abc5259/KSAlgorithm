package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while (K-- > 0) {
            int N = Integer.parseInt(br.readLine());
            double[] line = new double[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                line[i] = Double.parseDouble(st.nextToken());
            }

            Arrays.sort(line);
            double sum = 0;

            boolean flag = false;
            for (int i = 0; i < N - 1; i++) {
                sum += line[i];
                if (sum >= line[i + 1]) {
                    sb.append("YES");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

// S1 철사 연결 그리디
// 문제 조건에 따라 철사의 길이가 누적합을 가지며 다음 인자보다 클 조건일 떄 YES
// 계속해서 수를 가져갈 때 제일 큰 철사보다 작으면 폐곡선 형성 안됨

// Trouble shooting
// 끝까지 누적합을 비교하지말고 중간에 철사의 길이가 넘겼을 경우 조건탈출
// flag 세워서 활용