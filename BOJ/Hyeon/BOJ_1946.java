package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            int[][] scores = new int[N][2];

            StringTokenizer st;
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                scores[j][0] = Integer.parseInt(st.nextToken());
                scores[j][1] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(scores, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });
            int sum = 1;
            int tmp = scores[0][1];
            for (int j = 1; j < N; j++) {
                if (tmp > scores[j][1]) {
                    sum++;
                    tmp = scores[j][1];
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
// S1 신입 사원 그리디 알고리즘
// 일단 풀었다.
// 다른 솔루션 해결