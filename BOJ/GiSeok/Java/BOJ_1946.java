package BOJ.GiSeok.Java;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int cnt, max, N;
        int[][] ranks;

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            ranks = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                ranks[i][0] = Integer.parseInt(st.nextToken());
                ranks[i][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(ranks, (o1, o2) -> {
                return o1[0]-o2[0];
            });

            cnt = 1;
            max = ranks[0][1];

            for (int i = 1; i < N; i++) {
                if (max > ranks[i][1]) {
                    max = ranks[i][1];
                    cnt++;
                }
            }

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
    }
}