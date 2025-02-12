package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] meeting = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int preTime = 0;

        for (int i = 0; i < N; i++) {
            if (preTime <= meeting[i][0]) {
                preTime = meeting[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
// G5 회의실 배정 그리디 알고리즘
// 가장 기본 문제로써
// 회의실 시간을 겹치지 않게 많은 스케줄을 짜는 것이 목적이다.
// 많은 스케줄을 짜기 위해선 회의가 짧아야되고 짧은 회의는 빨리 끝나는 회의이다.
// 그래서 빨리 끝나는 회의를 기준으로 정렬해서 comparator를 사용하고
// 시작시간이 이전에 끝난 시간보다 클 경우 끝나는 시간을 이전으로 넣어주고 cnt++ 하면된다.