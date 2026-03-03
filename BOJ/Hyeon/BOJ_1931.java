package BOJ.Hyeon;

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

        int[][] meeting = new int[N][2];

        StringTokenizer st;

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

        int endTime = 0;

        for (int i = 0; i < N; i++) {
            if (endTime <= meeting[i][0]) {
                endTime = meeting[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

// G5 회의실 배정 그리디, 정렬 복습
// 11분
// 그리디로써 회의가 끝나마자마 바로 시작하는게 중요하기때문에
// 빨리 끝내는 순으로 정렬을 해버리고 endTime 보다 시작시간이 크거나 같은게 먼저 나오면 그 회의를 시작해버리면돼서
// 해당 조건에 맞게 회의가 끝나는 시간을 오름차로 정렬하고 cnt 개수를 반환해주는 문제.