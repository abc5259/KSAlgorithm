package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5800 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for (int t = 1; t <= K; t++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            int[] arr = new int[cnt];
            for (int i = 0; i < cnt; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int min = arr[0];
            int max = arr[cnt - 1];
            int gap = 0;

            for (int i = 1; i < cnt; i++) {
                int diff = arr[i] - arr[i - 1];
                if (gap < diff) {
                    gap = diff;
                }
            }

            sb.append("Class ").append(t).append("\n");
            sb.append("Max ").append(max).append(", Min ").append(min).append(", Largest gap ").append(gap).append("\n");
        }
        System.out.println(sb);
    }
}
// S5 성적 통계 구현
// 7분
// 그냥 풀었다. 너무 쉬운 구현 문제.