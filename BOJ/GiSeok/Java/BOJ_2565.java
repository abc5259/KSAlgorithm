package BOJ.GiSeok.Java;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] cable = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            cable[i][0] = Integer.parseInt(st.nextToken());
            cable[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.sort(cable, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < N; i++) {
            if (dp[i] == 0) dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (cable[i][1] > cable[j][1]) {
                    if (dp[i] < dp[j] + 1)
                        dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            if (max < dp[i])
                max = dp[i];
        }

        System.out.println(N-max);
    }
}
