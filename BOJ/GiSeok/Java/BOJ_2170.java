/**
 * 2170 - 선 긋기 [성공(반례힌트)|00:35:01]
 * 골드5, 라인스위핑, 시도3
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2170 {
    // 시간제한 1초, 메모리제한 192MB

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            paper[i][0] = Integer.parseInt(st.nextToken());
            paper[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(paper, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });

        int start = paper[0][0];
        int end = paper[0][1];
        int ret = 0;
        for (int i = 1; i < N; i++) {
            if (end >= paper[i][0]) {
                if (end < paper[i][1]) end = paper[i][1];
            } else {
                ret += (end - start);
                start = paper[i][0];
                end = paper[i][1];
            }
        }

        ret += (end - start);
        System.out.println(ret);
    }
}
