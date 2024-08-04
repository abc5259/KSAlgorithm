/**
 * 1931 - 회의실 배정 [성공(반례힌트)|00:20:46]
 * 실버1, 그리디, 시도3
 */
package BOJ.GiSeok.Java.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931 {
    // 시간제한 2초, 메모리제한 128MB
    // 한 개의 회의실. 이를 사용하려는 N개의 회의.
    // 각 회의마다 시작 시간 -> 끝나는 시간이 있다.
    // 각 회의가 겹치지 않으면서 회의실을 사용할 수 있는 최대 개수.

    // 1 <= N <= 100,000
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] meet = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meet[i][0] = Integer.parseInt(st.nextToken());
            meet[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meet, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] == o2[1]) ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        int ret = 0;
        int prev = -1;
        for (int i = 0; i < N; i++) {
            if (prev > meet[i][0]) continue;

            System.out.println(meet[i][0] + " -> " + meet[i][1]);
            prev = meet[i][1];
            ret++;
        }

        System.out.println(ret);
    }
}
